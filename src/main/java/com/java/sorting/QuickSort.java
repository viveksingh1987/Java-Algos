package com.java.sorting;

import java.util.Arrays;

// O(n2)
public class QuickSort {

    public static void main(String[] args) {
            int[] num = new int[]{3,4,2,6,9,8,7,5,1};
            int n = num.length;
            quickSort(num, 0, n-1);
            System.out.print(Arrays.toString(num));
        }

        public static int partition(int[] num, int low, int high) {
            int pivot = num[high];
            int replaceIndex = (low -1);
            for(int i = low; i<= high;i ++){
                if(num[i]<pivot){
                    replaceIndex ++;
                    swap(num,replaceIndex, i);
                }
            }
            swap(num, replaceIndex+1, high);
            return replaceIndex + 1;
        }

        public static void quickSort(int[] num, int low, int high) {
            if(low < high){
                int pi = partition(num, low, high);
                quickSort(num, low, pi-1);
                quickSort(num, pi+1, high);
            }
        }

        public static void swap(int[] num, int i, int j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
}
