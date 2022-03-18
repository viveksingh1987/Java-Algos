package com.java.algos;

/**
 * Best Time Complexity: O(n)
 * Worst: O(n2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        insertionSortNumber(new int[]{3,1,5,4,6,8,9});
    }

    public static void insertionSortNumber(int[] numbers) {

        for(int i = 1; i < numbers.length ; i++) {
            int numberToInsert = numbers[i];
            int j = i -1;
            while(j > 0 && numbers[j] > numberToInsert) {
                numbers[i] = numbers[j];
                j --;
            }
            numbers[j+1] = numberToInsert;
        }

        for(int i =0 ; i< numbers.length ; i++){
            System.out.print(numbers[i] + ", ");
        }
    }


}
