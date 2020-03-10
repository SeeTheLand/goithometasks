package com.dermentli.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.dermentli.util.Print.*;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        //User Input a and b
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        print("Please enter a");
        String sA = reader.readLine();
        int a = Integer.parseInt(sA);
        print("Please enter b");
        String sB = reader.readLine();
        int b = Integer.parseInt(sB);
        //function call
        print(addition(a, b));
        print(multiplication(a, b));
        print(division(a, b));
        print(subtraction(a, b));
        print(modulusDivision(a, b));
        print(isEqual(a, b));
        print(aLessThanB(a, b));
        print(aMoreThanB(a, b));
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int modulusDivision(int a, int b) {
        return a % b;
    }

    public static String isEqual(int a, int b) {
        String compare;
        if (a == b)
        {
            compare = "a and b are equal";
        }
        else
        {
            compare = "a and b are not equal";
        }
        return compare;
    }

    public static String aLessThanB(int a, int b) {
        String compare;
        if (a < b)
        {
            compare = "a is less than b";
        }
        else
        {
            compare = "a is not less than b";
        }
        return compare;
    }

    public static String aMoreThanB(int a, int b) {
        String compare;
        if (a > b)
        {
            compare = "a is more than b";
        }
        else
        {
            compare = "a is not more than b";
        }
        return compare;
    }
}
