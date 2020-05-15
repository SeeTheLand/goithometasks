package com.dermentli.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("task (1)");
//        upStream(10);
//        System.out.println("task (2)");
//        drawRectangle(3, 2);
//        System.out.println("task (3)");
//        drawRectangle(3);
//        System.out.println("task (4/1)");
//        System.out.println(getMax(15, 2));
//        System.out.println("task (4/2)");
//        System.out.println(getMax(1, 2.0f));
//        System.out.println("task (5)");
//        upStreamRecursive(12);
//        System.out.println("task (6)");
//        drawRectangleRecursives(3, 2, "");
//        System.out.println("task (7)");

        String answer;
        do {
            userInterface();
            System.out.println("Вы хотите продолжить решать задачи (y/n)?");
            answer = scanner.next();
        } while (answer.equals("y"));

    }

    public static void upStream(int x) {
        for (int i = 1; i <= x; i++) {
            System.out.println(i);
        }
    }
    public static void drawRectangle(int width, int height) {
        while (height > 0) {
            int i = width;
            while (i > 0) {
                System.out.print("+");
                i--;
            }
            height--;
            System.out.println();
        }
    }
    public static void drawRectangle(int size) {
        int b = size;
        while (b > 0) {
            int i = size;
            while (i > 0) {
                System.out.print("+");
                i--;
            }
            b--;
            System.out.println();
        }
    }
    public static int getMax(int a, int b) {
        return (a > b) ? a : b;
    }
    public static int getMax(int a, float b) {
        return (a > (int)b) ? a : (int)b;
    }
    public static void upStreamRecursive(int x) {
        if (x == 0) {
            return;
        } else {
            upStreamRecursive(--x);
            System.out.println(++x);
        }
    }
    public static void drawRectangleRecursives(int width, int height, String line) {
        if (height > 0) {
            if (width > 0) {
                drawRectangleRecursives(--width, height, line += "+");
            } else {
                System.out.println(line);
                drawRectangleRecursives(width, --height, line);
            }
        }
    }
    public static void userInterface() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Какую задачу вы хотите решить:");
            System.out.println("     1. Написать функцию которая выводит в консоли от 1 до числа Х.");
            System.out.println("     2. Написать функцию drawRectangle которая рисует в консоли прямоугольник из символов '+'");
            System.out.println("     3. Перегрузить функцию drawRectangle (задание 2) таким образом, чтобы она могла принимать на вход только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами.");
            System.out.println("     4. Написать функцию getMax которая принимает на вход два аргумента в виде чисел. А возвращает максимальное из этих двух.");
            System.out.println("     5. Решить задачу по написанию функции вывода в консоль, без использования циклов. Используя рекурсию.");
            System.out.println("     6. Решить задачу drawRectangle, без использования циклов. Используя рекурсию.");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 6);
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("Введите число для вызова функции");
                upStream(scanner.nextInt());
                break;
            case 2:
                System.out.println("Введите ширину");
                int width = scanner.nextInt();
                System.out.println("Введите высоту");
                int height = scanner.nextInt();
                drawRectangle(width, height);
                break;
            case 3:
                System.out.println("Введите ширину квадрата");
                width = scanner.nextInt();
                drawRectangle(width);
                break;
            case 4:
                System.out.println("Введите целое число а");
                int a = scanner.nextInt();
                System.out.println("Введите целое число б");
                int b = scanner.nextInt();
                System.out.println(getMax(a, b));
                System.out.println("Часть 2 - Введите целое число а");
                a = scanner.nextInt();
                System.out.println("Часть 2 - Введите дробное число б");
                float c = scanner.nextInt();
                System.out.println(getMax(a, c));
                break;
            case 5:
                System.out.println("Введите число для вызова функции из задачи 1 с рекурсией");
                a = scanner.nextInt();
                upStreamRecursive(a);
                break;
            case 6:
                System.out.println("Введите ширину для построения с рекурсией");
                width = scanner.nextInt();
                System.out.println("Введите высоту");
                height = scanner.nextInt();
                drawRectangleRecursives(width, height, "");
                break;
        }
    }

}


