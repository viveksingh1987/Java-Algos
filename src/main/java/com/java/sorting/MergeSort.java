package com.java.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] num = new int[]{3,4,2,6,9,8,7,5,1};

        int n = num.length;
        sort(num,0, n-1);

        System.out.println("Final Result: " + Arrays.toString(num));
    }


    public static void sort(int[] num, int left, int right) {
        if(left < right){
            int middle = (left + (right-1))/2;
            System.out.println("***********************************************");
            System.out.println("Array to divide: " + Arrays.toString(num));
            System.out.println("Middle Index: " + middle);



            sort(num, left, middle);
            sort(num, middle + 1, right);
            merge(num, left, middle, right);
        }
    }

    public static void merge(int[] num, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = num[left + i];
        }
        for(int i = 0; i < n2; i++){
            R[i] = num[middle + 1 + i];
        }
        System.out.println("Left Array: " + Arrays.toString(L));
        System.out.println("Right Array: " + Arrays.toString(R));

        int i = 0; int j =0;
        int k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                num[k] = L[i];
                i++;
            } else {
                num[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            num[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            num[k] = R[j];
            j++;
            k++;
        }
        System.out.println(" After Merge: " + Arrays.toString(num));
    }

}
