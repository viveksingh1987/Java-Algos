package com.java.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,4,2,6,9,8,7,5,1};

        int n = num.length;

       for(int i = 1; i < n ; i++) {
           int key = num[i];
           while(i > 0 && num[i-1] > key){
               num[i] = num[i-1];
               i--;
           }
           num[i] = key;
       }
        System.out.print(Arrays.toString(num));
    }
}
