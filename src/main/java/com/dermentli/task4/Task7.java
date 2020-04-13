package com.dermentli.task4;

import java.io.IOException;
import java.util.Scanner;

public class Task7 extends Main {

    public static void doSomeStaff() throws IOException {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
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
