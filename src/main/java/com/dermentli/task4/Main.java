package com.dermentli.task4;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("task (1)");
        upStream(10);
        System.out.println("task (2)");
        drawRectangle(3, 2);
        System.out.println("task (3)");
        drawRectangle(3);
        System.out.println("task (4/1)");
        System.out.println(getMax(15, 2));
        System.out.println("task (4/2)");
        System.out.println(getMax(1, 2.0f));
        System.out.println("task (5)");
        upStreamRecursive(12);
        System.out.println("task (6)");
        drawRectangleRecursives(3, 2, "");
        System.out.println("task (7)");
        Task7.doSomeStaff();
        String answer;
        do {
            System.out.println("Вы хотите продолжить решать задачи (y/n)?");
            answer = scanner.next();
        } while (!answer.equals("y") && !answer.equals("n"));

        if (answer.equals("y")) {
            Task7.doSomeStaff();
        }

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
        class Reverse {
            void reverseCall(int z, int x) {
                System.out.println((z+1) - x);
                if (x > 1) {
                    reverseCall(z, --x);
                }
            }
        }
        new Reverse().reverseCall(x, x);
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
}


