package com.java.datastructure;

import com.amazonaws.services.dynamodbv2.xspec.S;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.EncloseType;

import java.util.*;
import java.util.LinkedList;

public class TestBinarySearch {

    public Node root;

    public TestBinarySearch(){
        root = null;
    }
    public static void main(String[] args) {
        TestBinarySearch binarySearch = new TestBinarySearch();
        binarySearch.insert(20);
        binarySearch.insert(10);
        binarySearch.insert(1);
        binarySearch.insert(4);
        binarySearch.insert(2);
        binarySearch.insert(5);

        System.out.println("In Order Traversal");
        binarySearch.inOrderTraversal(binarySearch.root);
        System.out.println("\nPre Order Traversal");
        binarySearch.preOrderTraversal(binarySearch.root);
        System.out.println("\nPost Order Traversal");
        binarySearch.postOrderTraversal(binarySearch.root);

        System.out.println("\n*****************Compare binary tree **********");
        Node x = new Node(1);
        x.left = new Node(2);
        x.right = new Node(3);
        x.left.left = new Node(4);
        x.left.right = new Node(5);
        x.right.left = new Node(6);
        x.right.right = new Node(7);

        Node y = new Node(1);
            y.left = new Node(2);
        y.right = new Node(3);
        y.left.left = new Node(4);
        y.left.right = new Node(5);
        y.right.left = new Node(6);
        y.right.right = new Node(7);

        System.out.println(binarySearch.isIdentical(x,y));
        System.out.print("Is BST: " +isBST(y));
        printBottomView(y);
        System.out.println("Number of Leaf nodes: " +getLeafCount(y));
        System.out.println("Tree is Height Balanced: " + isBalancedTree(y));
        System.out.println("Height of Tree: " + treeHeight(y));
        System.out.println("Left View of the tree");
        leftView(y);
    }
//****************************************************************** Recursive Methods
    public void inOrderTraversal(Node node) {
        if(node == null){
            System.out.println("Tree is empty");
            return;
        }
        if(node.left != null){
            inOrderTraversal(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right != null){
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if(node == null){
            System.out.println("Tree is empty");
            return;
        }

        if(node.left != null){
            preOrderTraversal(node.left);
        }
        if(node.right != null){
            preOrderTraversal(node.right);
        }
        System.out.print(node.data + " ");

    }

    public void preOrderTraversal(Node node) {
        if(node == null){
            System.out.println("Tree is empty");
            return;
        }
        System.out.print(node.data + " ");
        if(node.left != null){
            preOrderTraversal(node.left);
        }
        if(node.right != null){
            preOrderTraversal(node.right);
        }

    }


    public boolean isIdentical(Node x, Node y) {
        if(x == null && y == null){
            return true;
        }
        boolean result = ((x != null && y != null) && (x.data == y.data) && isIdentical(x.left, y.left) && isIdentical(x.right, y.right) );
                return result;
    }

    //****************************************************************** Stack Methods

    public void inorderStack(Node node) {
        Stack<Node> stack = new Stack<>();

        Node current = node;

        while(current != null || !stack.empty()) {
            if(current != null){
                stack.push(node);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.data + "");
                current = current.right;
            }
        }
    }

    public void preorderStack(Node node) {
        if(node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.empty()) {
            Node current = stack.pop();
            System.out.print(current.data + "");

            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
    }


    public void postorderStack(Node node) {
        if(node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Stack<Integer> out = new Stack<>();

        while(!stack.empty()) {
            Node current = stack.pop();
            out.push(current.data);
            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }

            while(!out.empty()){
                System.out.print(out.pop() + "");
            }
        }
    }



    public void insert( int data) {
        Node newNode = new Node(data);

        if(root == null){
            root = newNode;
            return;
        } else {
            Node current = root;
            Node parent = null;

            while(true){
                parent = current;

                if(data < current.data) {
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Check is tree is Binary Search Tree
     * @param node
     * @return
     */
    public static boolean isBST(Node node){
        if(node == null) return false;
        if(node.left != null && node.left.data > node.data) return false;
        if(node.right != null & node.right.data > node.data) return false;
        if(!isBST(node.left) || !isBST(node.right)) return false;
        return true;
    }


    public static void leftViewUtil(Node node, int level) {
            if( node == null) return;
        if(max_level < level){
            System.out.println(" " + node.data);
            max_level = level;
        }
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    static int max_level = 0;
    public static void leftView(Node node){
        leftViewUtil(node, 1);
    }
    /**
     * Print Bottom view of the Tree
     */

    public static void printBottomView(Node root) {

        if(root == null) return;

        Queue<NodeObject> queue = new LinkedList<NodeObject>();
        Map<Integer, Integer> bottomview = new TreeMap<>();

        queue.add(new NodeObject(root, 0));

        while(!queue.isEmpty()){
            NodeObject current = queue.poll();
            Node tempNode = current.node;
            int hd = current.hd;

            bottomview.put(hd, tempNode.data);

            if(tempNode.left != null) {
                queue.add(new NodeObject(tempNode.left, hd -1));
            }

            if(tempNode.right != null){
                queue.add(new NodeObject(tempNode.right, hd+1));
            }
        }

        for(Map.Entry<Integer, Integer> entry: bottomview.entrySet()){
            System.out.println(entry.getValue() + " ");
        }

    }

    // get the count of leaf nodes in binary tree
    public static int getLeafCount(Node root){
            if( root == null) return 0;
            if( root.left == null && root.right == null) return 1;
            return getLeafCount(root.left) + getLeafCount(root.right);
    }

    //determine if binary tree is height balanced or not
    public static boolean isBalancedTree(Node root){
        int lh, rh;
        if(root == null) return true;

        lh = treeHeight(root.left);
        rh = treeHeight(root.right);

        if(Math.abs(lh-rh) <= 1
                && isBalancedTree(root.left)
                && isBalancedTree(root.right)) {
            return true;
        }
        return  false;
    }

    public static int treeHeight(Node node){
        if(node == null) return 0;
        return 1+ Math.max(treeHeight(node.left), treeHeight((node.right)));
    }

    public static int countLeaf(Node node) {
        if(node == null) return 0;
        if( node.left == null && node.right == null) return 1;
        return countLeaf(node.left) + countLeaf(node.right);
    }

    public static int nodeCount(Node node){
        if(node == null) return 0;
        return 1 + nodeCount(node.left) + nodeCount(node.right);
    }


}
