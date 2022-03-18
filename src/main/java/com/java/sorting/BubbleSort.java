package com.java.sorting;

// O(n2)
public class BubbleSort {

    public static void main(String[] args) {
        int[] num = new int[]{3,4,1,2,7,5,8,6};
        for(int j =0 ; j< num.length ; j++){
            for(int i = 0; i < num.length -1; i++){
                if(num[i] > num[i+1]){
                    int temp = num[i+1];
                    num[i+1] = num[i];
                    num[i] = temp;
                }
            }
        }
        for(int i =0 ; i< num.length ; i ++){
            System.out.print(num[i] + ", ");
        }

    }
}
