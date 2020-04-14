package com.dermentli.part3_revised;

import com.dermentli.task3.CountRepeatingElements;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String sArraySize = reader.readLine();

        //task 1)
        //int arraySize = Integer.parseInt(sArraySize); //getting array size

        //task 2)
        System.out.println("Pls enter array with whitespace delimiter");
        String stringToSplit  = reader.readLine(); //reading input for further splitting
        int[] inputArray = convertStringWithWhitespace(stringToSplit);

        //task 3)
        minInArray(inputArray);
        //task 4)
        maxInArray(inputArray);
        //task 5)
        occurrenceOfFive(inputArray);
        //task 6)
        sortArray(inputArray);

        //task 7) + 8)
        compareRepeat(inputArray);

        //task 9) сразу работает без явного ввода длины массива

    }

    public static int[] convertStringWithWhitespace(String stringToSplit) {
        //creating array of digits
        String[] sDigitArray = stringToSplit.split("\\s+");
        int[] inputArray = new int[sDigitArray.length];

        //transferring String array to int, till int capacity reached
        try {
            for (int i=0; i<sDigitArray.length; i++) {
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
        Arrays.sort(inputArray);
        int maxRepeat = Integer.MIN_VALUE; //задаем мин мат значение для послед обработки
        int minRepeat = Integer.MAX_VALUE; //задаем макс мат значение для послед обработки
        int previous = inputArray[0]; //будет хранить предыдущий элемент отсортированного массива для сравнения с текущим
        int buffer = 0; //будет считать кол-во повторений для текущего элемента
        int maxVar = 0; //будет хранить значение элемента массива, повторяющееся наибольшее кол-во раз
        int minVar = 0; //минимальное кол-во раз

        for (int i : inputArray) {
            if (i == previous) {            //сравниваем тек элемент с предыд
                buffer++;                   //если равны инкремент буффер
            } else {
                if (buffer > maxRepeat) {   //если не равны, то проверяем буффер относится к мин или макс элементам
                    maxRepeat = buffer;
                    maxVar = previous;      //если буфер больше, чем значение максимальных повторений прошлых проходов, то меняем значения из массива с макс повторениями
                }
                if (buffer < minRepeat) {
                    minRepeat= buffer;
                    minVar = previous;
                }
                previous = i;   //меняем предыдущее значения для следующего цикла
                buffer = 1;     //присваиваем значение 1 буффер, т.к. у нас появидся новый элемент для следующего прохода
            }
        }

        System.out.println("Ответ - " + maxRepeat +". Так как число " + maxVar + " повторяется " + maxRepeat + " раза");
        System.out.println("Ответ - " + minRepeat +". Так как число " + minVar + " повторяется " + minRepeat + " раза");

    }

}
