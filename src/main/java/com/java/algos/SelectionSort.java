package com.java.algos;

import java.util.Arrays;

/**
 * Time complexity: O(n2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        selectionSort(new int[]{3,4,5,2,1,6});

    }

    public static void selectionSort(int[] numbers) {
        int n = numbers.length;
        for(int i = 0 ; i < n-1 ; i ++){
            int minElement = i;
            for(int j = i ; j < n ; j++){
                if(numbers[j] < numbers [minElement]) {
                    minElement = j;
                    int temp = numbers[minElement];
                    numbers[minElement] = numbers [i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
