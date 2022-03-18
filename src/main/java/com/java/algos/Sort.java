package com.java.algos;

import com.amazonaws.services.dynamodbv2.xspec.S;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        bubbleSort();
        insertionSort();
        selectionSort();
    }

    public static void selectionSort() {
        int[] nums = {1,5,3,4,2,6,7};
        int n = nums.length;
        for(int i =0; i< n-1 ; i ++){
            int minElement = i;
            for(int j = i ; j < n ; j++){
                if(nums[j] < nums[minElement]){
                    minElement = j;
                    int temp = nums[minElement];
                    nums[minElement] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort() {
        int[] nums = {1,5,3,4,2,6,7};
        int n = nums.length;
        for(int i=1; i<n; i++){
            int numberToInser = nums[i];
            int j = i -1;
            while(j >0 && nums[j] > numberToInser){
                nums[i] = nums[j];
                j--;
            }
            nums[j+1] = numberToInser;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(){
        int[] nums = {1,5,3,4,2,6,7};
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=0; j < n-1; j ++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }



    public static  mergeSort() {
        int[] nums = {1,5,3,4,2,6,7};
        int n = nums.length;
            merges(nums, n-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void merges(int[] nums, int length){
        if(length < 2){
            return;
        }
        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for(int i=0; i< mid; i ++){
            left[i] = nums[i];
        }
        for(int i=mid; i< length; i ++){
            left[i-mid] = nums[i];
        }

        merges(left, mid);
        merges(right, length-mid);
        merge(nums,  left, right, mid, length-mid);
    }

    public static void merge(int[] nums, int[] left, int[] right, int l, int r){

        int i =0;
        int j =0;
        int k=0;
        while(i< l && j< r){
            if(left[i]<right[j]){
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while(i<l){
            nums[k++] = left[i++];
        }
        while(j < r){
            nums[k++] = right[j++];
        }
    }

    public void quickSort() {

    }


}
