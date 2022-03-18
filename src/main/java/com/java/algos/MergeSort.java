package com.java.algos;

/**
 * https://www.geeksforgeeks.org/merge-sort/
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{3,8,2,6,1,9,7};
        mergeSort(numbers, numbers.length );
    }

    public static void mergeSort(int[] numbers, int length) {

        if(length < 2){
            return;
        }

        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid ; i ++) {
            left[i] = numbers[i];
        }
        for(int j = mid; j < length ; j++){
            right[j-mid] = numbers[j];
        }
        mergeSort(left,mid);
        mergeSort(right, length - mid);

        merge(numbers, left,right,mid,length-mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
