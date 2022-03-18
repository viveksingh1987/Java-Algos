package com.java.test;

import com.java.datastructure.Node;
import com.java.datastructure.NodeObject;

import javax.management.Query;
import java.util.*;

public class TestTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.right = new Node(5);
        node2.right.left = new Node(6);
        node2.right.right = new Node(7);
        System.out.println(diameter(node));
    }

    static class A
    {
        int ans = Integer.MIN_VALUE;
    }

    public static int height(Node node, A a){
        if(node == null) return 0;
        int left_height = height(node.left, a);
        int right_height= height(node.right, a);
        a.ans = Math.max(a.ans, 1+ left_height + right_height);
        return 1 + Math.max(left_height , right_height);
    }

    public static int diameter(Node node){
        if( node == null) return 0;
        A a = new A();
        int treeHeight = height(node, a);
        return a.ans;


    }

}
