package com.datastruct.lru;

import java.util.HashMap;

/**
 * 双向链表+hashmap
 */
public class LRUCache {
    //lru
    Node first;
    Node last;
    int MAX_CACHE_SIZE;

    //存储数据
    private HashMap<Integer,Node> hashMap = new HashMap<>();

    public LRUCache(int capacity) {
        MAX_CACHE_SIZE = capacity;
    }

    public synchronized int get(int key) {
        Node node = hashMap.get(key);
        if(node!=null){
            moveToHeader( node);
            return node.item;
        }else{
            return -1;
        }
    }

    public synchronized void put(int key, int value) {
        //容量超标
        if(hashMap.size()>=MAX_CACHE_SIZE){
            deleteLastNode();
        }
        Node node = hashMap.get(key);
        //key已经存在
        if(node!=null){
            node.item=value;
            hashMap.put(key,node);
            //将key对应的linkNode移到header
            moveToHeader(node);
        }else{
            Node nd = new Node(key);
            hashMap.put(key,nd);
            //放在链表最前
            setToHeader(nd);
        }

    }

    public synchronized void deleteLastNode(){
        //删除链表尾端node
        Node pre = last.prev;
        pre.next=null;
        last=pre;
    }


    public synchronized void moveToHeader(Node node){
        //已经是头结点
        if(node.prev==null){
            return ;
        }
        Node pre = node.prev;
        Node next = node.next;
        //删除当前节点,即头结点直接指向下一个节点
        pre.next = next;

        //放到头结点
        node.next = first;
        first = node;
    }
    public synchronized void setToHeader(Node node){
        if(first==null){
            first=node;
            last=node;

        }else{
            node.next=first;
            first =node;

            last.prev=node;
        }

    }


    class Node{
        int item;
        Node next;
        Node prev;

        Node(int element){
            item = element;
        }


        Node(Node prev, int element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.get(1);
        lruCache.put(4,4);
        System.out.println("lruCache = " + lruCache.hashMap);
    }

}
