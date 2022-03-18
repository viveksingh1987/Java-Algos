package com.java.datastructure;

import java.util.Stack;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = null;
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


    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();

        binaryTree.insert(30);
        binaryTree.insert(20);
        binaryTree.insert(10);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(40);
        binaryTree.insert(33);

        binaryTree.binaryTreeInorderTraversal(binaryTree.root);


        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);

        System.out.println("Initialize normal Tree");
        binaryTree.binaryTreeInorderTraversal(root);
        System.out.println("Using Stack");
        binaryTree.inorderUsingStack(root);


        System.out.println("\n=============== PRE ORDER TRAVERSAL: Recurssion ===================");
        binaryTree.preOrderTraversal(root);
        System.out.println("\n=============== PRE ORDER TRAVERSAL: Iteration ===================");
        binaryTree.preorderUsingStack(root);
    }

    public void inorderUsingStack(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;

        while(current !=null || !stack.empty()) {

            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }

    }

    public void preorderUsingStack(Node node) {
        // return if the tree is empty
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.empty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left !=null ) {
                stack.push(current.left);
            }
            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }

    public void preOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void binaryTreeInorderTraversal(Node node) {
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }

        if(node.left != null){
            binaryTreeInorderTraversal(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right != null) {
            binaryTreeInorderTraversal(node.right);
        }
    }

    public Node minNode(Node root) {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    public Node deleteNode(Node node, int value) {

        if(node == null ) {
            return null;
        }

        if(value < node.data) {
            node.left = deleteNode(node.left, value);
        } else if(value > node.data) {
            node.right = deleteNode(node.right, value);
        } else {
            if( node.left == null && node.right == null){
                node = null;
            } else if(node.left == null) {
                node = node.right;
            } else if(node.right == null) {
                node = node.left;
            } else {
                //then find the minimum node from right subtree
                Node temp = minNode(node.right);
                //Exchange the data between node and temp
                node.data = temp.data;
                //Delete the node duplicate node from right subtree
                node.right = deleteNode(node.right, temp.data);
            }
        }
        return node;
    }
}
