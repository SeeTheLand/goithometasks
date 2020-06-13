package com.dermentli.task9;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("first");
        testList.add("second");
        testList.add("third");
        System.out.println(testList.elementData[0]);
        System.out.println(testList.elementData[1]);
        System.out.println(testList.get(1));
        System.out.println(testList.elementData[2]);
        testList.remove(1);
        System.out.println(testList.elementData[0]);
        System.out.println(testList.elementData[1]);
        testList.clear();
        System.out.println(testList.elementData[0]);
        System.out.println(testList.size());
    }
}
