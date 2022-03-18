package com.java.algos;

/**
 * Time Complexity
 * Normal : O(n)
 * Worst: O(n2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        bubbleShortNumber(new int[]{3,5,1,2,8,4,9,7,6});
        bubbleShortString(new String[]{"Ada", "Lisa", "Viv", "Java", "Scala"});
    }


    public static void bubbleShortNumber(int[] numbers) {

        for(int i = 0; i < numbers.length; i++){
            for(int j = 0 ; j < numbers.length -1; j ++){
                if(numbers[j] > numbers[j +1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        for(int i =0 ; i< numbers.length ; i ++){
            System.out.print(numbers[i] + ", ");
        }
    }


    public static void bubbleShortString(String[] words) {

        for(int i = 0; i < words.length; i++){
            for(int j = 0 ; j < words.length -1; j ++){
                if(words[j].compareTo(words[j +1]) > 0){
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }

        for(int i =0 ; i< words.length ; i ++){
            System.out.print(words[i] + ", ");
        }
    }
}
