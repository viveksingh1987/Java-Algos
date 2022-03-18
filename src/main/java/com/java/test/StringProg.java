package com.java.test;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.*;

public class StringProg {

    public static void main(java.lang.String[] args) {
        permutationOfString();



    }

    public static void permutationOfString() {
        String str= "ABC";
        findPermutation(str);
    }

    public static void findPermutation(String str){
        if(str == null || str.length() == 0){
            return;
        }
        permutation(str.toCharArray(), 0);
    }

    public static void permutation(char[] chars, int currentIndex){
        if (currentIndex == chars.length - 1) {
            System.out.println(String.valueOf(chars));
        }

        for(int i=currentIndex ; i<chars.length; i++ ){
            swap(chars, currentIndex, i);
            permutation(chars, currentIndex + 1);
            swap(chars, currentIndex, i);
        }
    }
    private static void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }






    public static void sumOfPrimeNumber() {
        int count, sum = 0;
        for(int number = 1; number < 100; number++){
            count = 0;
            for(int i=2; i<= number/2 ; i++){
                if(number%i ==0){
                    count++;
                    break;
                }
            }

            if(count ==0 && number != 1){
                sum = sum + number;
            }
        }
        System.out.println(sum);


        int sum2=0;
        boolean isPrime = true;
        for(int i=1; i<100 ; i++){
            isPrime = true;
            for(int j=2; j < i ; j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && i != 1){
                sum2 = sum2 + i;
            }
        }
        System.out.println(sum2);

    }

    public static void findUnCommonChar(){
        java.lang.String a = "victor";
        java.lang.String b = "vickey";

        Set<java.lang.String> common = new HashSet<java.lang.String>();
        for(int j=0; j< b.length();j++){
            if(a.indexOf(b.charAt(j)) >= 0){
                common.add(b.charAt(j) + "");
            }
        }
        System.out.println(common);
        Set<java.lang.String> set = new HashSet<java.lang.String>();
        for(int i=0;i<a.length() ;i++){
            for(int j=0; j< b.length();j++){
                if(a.charAt(i) == b.charAt(j)){
                    set.add(a.charAt(i) + "");
                }
            }
        }
        System.out.println(set);


        HashMap<Character, Integer> records = new HashMap<Character, Integer>();

        for(int i=0; i< a.length() ;i++){
            if(records.containsKey(a.charAt(i)) == false){
                records.put(a.charAt(i), 1);
            }
        }
        for(int i=0; i< b.length(); i++){
            if(records.containsKey(b.charAt(i)) == false){
                records.put(b.charAt(i), 2);
            } else {
                if(records.get(b.charAt(i)) ==1){
                    records.put(b.charAt(i), 3);
                }
            }
        }

        for(Character c: records.keySet()){
            if(records.get(c) != 3){
                System.out.println(c);
            }
        }
    }

    public static void CheckSubSequence(){
        java.lang.String a = "horizon";
        java.lang.String b = "abhoridizaonr";

        java.lang.String longer = a.length() > b.length() ? a : b;
        java.lang.String shorter = a.length() < b.length() ? a: b;

        int j =0;
        for(int i = 0; i< longer.length() && j < shorter.length(); i++) {
            if(longer.charAt(i) == shorter.charAt(j)){
                j++;
            }
        }

        if(j == shorter.length()){
            System.out.println("Matched");
        } else {
            System.out.println("Not Matched");
        }

    }
    public void findMissingNumber(){
        int[] numbers = new int[]{3,7,1,2,8,4,5};
        int length = numbers.length;
        int sum = ((length +1) *(length +2))/2;
        System.out.println(sum);
        for(int i =0; i< length;i++){
            sum = sum - numbers[i];
        }
        System.out.println(sum);
    }

    public static void findMinMax(){
        int[] number = new int[]{2,3,12,4,5,6,10,7};
        int min = number[0];
        int max = number[0];

        for(int i=0; i < number.length ; i++){
            if(number[i] > max){
                max = number[i];
            } else if( number[i] < min){
                min = number[i];
            }
            System.out.println(number[i]);
        }
        System.out.println("Min: " + min + " | Max: " + max);

    }

    public static void rotateElementByDElement(){
        int[] number = new int[]{2,3,12,4,5,6,10,7};
        int rotateBy = 12;
        int length = number.length;

        int index = 0;
        for(int i = 0 ; i < length; i++) {
                if(number[i] == 12) {
                    index = i;
                }
        }

        for(int i=0; i < index ; i++){
            int temp = number[i];
            for(int j = 0; j< length -1 ; j ++){
                number[j] = number[j+1];
            }
            number[length-1] = temp;
        }
        System.out.println(Arrays.toString(number));
    }

    public static void removeDuplicateElement(){
        int[] number = new int[]{5,3,12,4,5,6,10,7};
        int[] temp = new int[number.length];

        Stack stack = new Stack<>();
        for(int i=0; i <  number.length ; i ++){
            if(!stack.contains(number[i])) {
                stack.push(number[i]);
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop() + "");
        }
    }

    public static void stringIsPallindrome(){
        java.lang.String original = "malayalam";
        java.lang.String reverse="";

        StringBuilder s = new StringBuilder();
        s.append(original);
        s.reverse();
        System.out.println("Reverse: " + s.toString());


        if(original.compareTo(s.toString()) ==0){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }



        for(int i = original.length()-1 ; i>=0;i--){
            reverse =  reverse + original.charAt(i);
        }
        System.out.println("Reverse: " + reverse);
    }
}
