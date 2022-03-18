package com.java.datastructure;

import com.amazonaws.services.networkmanager.model.Link;

public class LinkedList {

    public static void main(String[] args) {

        mergeTwoLinkedListInReverse();
    }


    public static void mergeTwoLinkedListInReverse() {

        LinkedListNode n1 = null;
        LinkedListNode n2 = null;

        for(int i = 9 ; i >=1 ; i= i-2){
            n1 = new LinkedListNode(i, n1);
        }
        for(int i= 6 ; i >=0; i=i-2){
            n2 = new LinkedListNode(i, n2);
        }

        /////////////////////////////////////////////

        LinkedListNode result = null;

        while(n1 != null && n2 != null){
            if(n1.data < n2.data){

                    LinkedListNode newNode = n1;
                    n1 = n1.next;
                    newNode.next = result;
                    result = newNode;
            } else {
                LinkedListNode newNode = n2;
                n2 = n2.next;
                newNode.next = result;
                result = newNode;
            }
        }

        while ( n2 != null){
            LinkedListNode newNode = n2;
            n2 = n2.next;

            newNode.next = result;
            result = newNode;
        }

        while ( n1 != null){
            LinkedListNode newNode = n1;
            n1 = n1.next;

            newNode.next = result;
            result = newNode;
        }

        while(result != null){
            System.out.print(result.data + " ");
            result = result.next;
        }

    }

}


