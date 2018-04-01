package com.datastruct.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 广度优先搜索算法
 */
public class BFSearch {
    private static Map searchedNode = new HashMap();
    private static BlockingDeque<Node> searchQue=new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Node node = init();
        searchQue.offer(node);
        while(searchQue.size()>0){
            Node rnode =  search(searchQue.poll(),"l");
            if(rnode!=null){
                System.out.println("find " + rnode.toString());
            }

        }

    }

    /**
     *
     * @param node
     * @param nodeName
     */
    public static Node search(Node node,String nodeName){
        if(searchedNode.containsKey(node.nodeName)){
            return null;
        }
        System.out.println("now search node: = " + node.nodeName);
        searchedNode.put(node.nodeName,node);
        if(nodeName.equals(node.nodeName)){
            return node;
        }else if(node.nodeList!=null&&node.nodeList.size()>0){
            node.nodeList.stream().forEach(e->searchQue.push(e));
        }else{
            return null;
        }
        return null;
    }



    public static Node init(){
        //初始化关系链
        Node originNode = new Node("originNode","1");
        Node node1_1 = new Node("a","1");
        Node node1_2 = new Node("b","2");
        Node node1_3 = new Node("c","1");
        Node node1_4 = new Node("d","1");
        originNode.nodeList = Arrays.asList(node1_1,node1_2,node1_3,node1_4);

        Node node1_5 = new Node("e","2");
        Node node1_6 = new Node("f","2");
        node1_1.nodeList=Arrays.asList(node1_5,node1_6);


        Node node1_7 = new Node("g","1");
        Node node1_8 = new Node("h","1");
        node1_2.nodeList=Arrays.asList(node1_5,node1_6,node1_7,node1_8);

        Node node1_9 = new Node("i","1");
        Node node1_10 = new Node("j","1");

        node1_5.nodeList=Arrays.asList(node1_9,node1_10,node1_7,node1_8);

        Node node1_11 = new Node("k","1");
        Node node1_12 = new Node("l","1");
        node1_8.nodeList=Arrays.asList(node1_11,node1_12);

        return originNode;
    }

    static class Node{
        String nodeName;
        String nodeValue;
        List<Node> nodeList;
        public Node(String nodeName,String nodeValue){
            this.nodeName=nodeName;
            this.nodeValue=nodeValue;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "nodeName='" + nodeName + '\'' +
                    ", nodeValue='" + nodeValue + '\'' +
                    ", nodeList=" + nodeList +
                    '}';
        }
    }

}
