package com.java.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayAlgos {
    public static void main(String[] args) {
        countTriplets();
    }








    public static void countTriplets(){
            int N = 4;
            int A[] = {1, 5, 3, 2};
            int count = 0;
            Arrays.sort(A);
            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    for(int k = j + 1; k < N; k++){
                        if(A[i] + A[j] == A[k]){
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);

    }
    public static void mergeTwoSortedArrays(){
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};

        int an = a.length;
        int bn = b.length;

        int[] resultArray = new int[an + bn];
        System.out.print(a.length);

        int k =0;
        for(int i=0; i<an; i++){
            resultArray[i] = a[i];
            k++;
        }
        for(int i=0; i< bn; i++){
            resultArray[k + i] = b[i];
        }
        // Sorting require

        int[] arr3 = new int[an + bn];

        int i=0, j=0,l=0;

        while(i < an && j < bn){
            if(a[i]< b[j]){
                arr3[l++] = a[i++];
            }else {
                arr3[l++] = b[j++];
            }
        }

        while(i< an){
            arr3[l++] = a[i++];
        }

        while(j< bn){
            arr3[l++] = b[j++];
        }

        System.out.print(Arrays.toString(arr3));

    }

    public static void findLargestNumberFormed() {
        List<Integer> numbers = Arrays.asList(10, 68, 97, 9, 21, 12);
        Collections.sort(numbers, (a, b)-> (String.valueOf(a)+b).compareTo(String.valueOf(b) + a));
        String a = numbers.stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.print(a);

    }
    public static void sortFirstArrayBasedOnSecondArray() {
        int[] firstArr = {5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4};
        int[] secondArr = {3, 5, 7, 2 };

        Map<Integer, Integer> frequency = new TreeMap<>();

        for(int i : firstArr){
            frequency.put(i, frequency.get(i) != null ? (frequency.get(i).intValue() + 1) : 1);
        }
        int index = 0;
        for(int i: secondArr){
            int n = ((frequency.get(i) != null) ? frequency.get(i) : 0);
            while(n-- > 0){
                firstArr[index] = i;
                index++;
            }
            frequency.remove(i);
        }

        for ( Map.Entry entry: frequency.entrySet())
        {
            int count = (int) entry.getValue();
            while (count-- > 0) {
                firstArr[index++] = (int)entry.getKey();
            }
        }

        System.out.print("Final: " + Arrays.toString(firstArr));
    }
}


