package com.datastruct.stack;

import java.util.LinkedList;

public class Stack {

    public static void main(String[] args) {
        java.util.Stack stack = new java.util.Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());

        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        System.out.println("linkedList = " + linkedList.pollLast());
        System.out.println("linkedList = " + linkedList.pollLast());
        System.out.println("linkedList = " + linkedList.pollLast());

    }
}
