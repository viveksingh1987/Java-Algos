package com.java.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,4,2,6,9,8,7,5,1};
        int n = num.length;
        for(int i=0; i< n-1; i++){
            int min = i;
            for(int j = i +1 ; j<n; j ++){
                if(num[j] < num[min]){
                    min = j;
                }
            }
            int temp = num[min];
            num[min] = num[i];
            num[i] = temp;
        }
        System.out.print(Arrays.toString(num));
    }
}
