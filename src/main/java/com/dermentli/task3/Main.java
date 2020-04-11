package com.dermentli.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sArraySize = reader.readLine();

        //task 1)
        int arraySize = Integer.parseInt(sArraySize); //getting array size

        //task 2)
        String stringToSplit  = reader.readLine(); //reading input for further splitting
        int[] inputArray = convertStringWithWhitespace(stringToSplit, arraySize);

        //task 3)
        minInArray(inputArray);
        //task 4)
        maxInArray(inputArray);
        //task 5)
        occurrenceOfFive(inputArray);
        //task 6)
        sortArray(inputArray);

        //task 7) + 8) -- можно было сделать через сортировку массива, но через множество на мой взгляд лучше
        compareRepeat(inputArray);

        //task 9) -- вывел как ДопЗадание task3.part9 (чтобы здесь не комментировать код)

    }

    public static int[] convertStringWithWhitespace(String stringToSplit, int arraySize) {
        //creating array of digits
        int[] inputArray = new int[arraySize];
        String[] sDigitArray = stringToSplit.split("\\s+");
        //transferring String array to int, till int capacity reached
        try {
            for (int i=0; i<arraySize; i++) {
                inputArray[i] = Integer.parseInt(sDigitArray[i]);
            }
            //System.out.println(Arrays.toString(inputArray));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Your array is too short");
        }
        return inputArray;
    }

    public static void minInArray(int[] inputArray) {
        int minimalInArray = inputArray[0];
        for (int a : inputArray) {
            minimalInArray = (minimalInArray > a) ? a : minimalInArray; //without Math.min
        }
        System.out.println("Minimal " + minimalInArray);
    }

    public static void maxInArray(int[] inputArray) {
        int maxInArray = 0;
        for (int a : inputArray) {
            maxInArray = Math.max(maxInArray, a);
        }
        System.out.println("Maximum " + maxInArray);
    }

    public static void occurrenceOfFive (int[] inputArray) {
        int countFive = 0;
        for (int a : inputArray) {
            if (a == 5) {
                countFive++;
            }
        }
        System.out.println("We found digit 5 in your array: " + countFive + " times");
    }

    public static void sortArray (int[] inputArray) {
        Arrays.sort(inputArray);
        System.out.println("Sorted array: " + Arrays.toString(inputArray));
    }

    public static void compareRepeat (int[] inputArray) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String minValue = null;
        String maxValue = null;
        CountRepeatingElements result = new CountRepeatingElements();
        Map<Object, AtomicInteger> dataSorted = result.countRepeatingElements(inputArray);
        for(Map.Entry<Object, AtomicInteger> entry : dataSorted.entrySet()){
            if(entry.getValue().intValue() < min){
                min = entry.getValue().intValue();
                minValue = entry.getKey().toString();
            }
            if(entry.getValue().intValue() > max){
                max = entry.getValue().intValue();
                maxValue = entry.getKey().toString();
            }
            // entry.getValue()
            // entry.getKey()
        }

        System.out.println("Ответ - " + max +". Так как число " + maxValue + " повторяется " + max + " раза");
        System.out.println("Ответ - " + min +". Так как число " + minValue + " повторяется " + min + " раза");

    }

}
