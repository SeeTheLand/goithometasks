package com.dermentli.task2;

import java.util.Scanner;

public class SolutionOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner.next();
        System.out.println("Please enter your place of living");
        String placeOfLiving = scanner.next();
        System.out.println("Please enter your age");
        int age = scanner.nextInt();
        System.out.println("Please enter your place of hobby");
        String hobby = scanner.next();

        //первый вывод
        System.out.println("Вариант 1 (табличный):");
        System.out.println("Имя:        " + name);
        System.out.println("Город:      " + placeOfLiving);
        System.out.println("Возраст:    " + age);
        System.out.println("Хобби:      " + hobby);
        
    }

}
