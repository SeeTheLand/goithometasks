package com.dermentli.task9;

import java.util.Arrays;

public class MyQueue<T> {
    transient Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;

    public MyQueue() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    T elementData(int index) {
        return (T) elementData[index];
    }

    public boolean add(T t) {
        int oldCapacity = size;
        size++;
        elementData = Arrays.copyOf(elementData, size);
        elementData[oldCapacity] = t;
        return true;
    }

    public T remove(int index) {
        T oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return elementData(index);
    }

    public T peek() {
        return get(size-1);
    }

    public T poll() {
        T x = get(size-1);
        remove(size-1);
        return x;
    }
}
