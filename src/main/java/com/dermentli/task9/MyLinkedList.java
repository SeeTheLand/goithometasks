package com.dermentli.task9;

public class MyLinkedList<T> {
    transient int size = 0;
    transient MyLinkedList.Node<T> first;
    transient MyLinkedList.Node<T> last;

    private static class Node<T> {
        T item;
        MyLinkedList.Node<T> next;
        MyLinkedList.Node<T> prev;

        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean add(T t) {
        linkLast(t);
        return true;
    }

    void linkLast(T t) {
        final MyLinkedList.Node<T> l = last;
        final MyLinkedList.Node<T> newNode = new MyLinkedList.Node<>(l, t, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    MyLinkedList.Node<T> node(int index) {
        //перебираем до нужного элемента с делением пополам размера листа
        if (index < (size >> 1)) {
            MyLinkedList.Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedList.Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public T remove(int index) {
        final T element = node(index).item;
        final MyLinkedList.Node<T> next = node(index).next;
        final MyLinkedList.Node<T> prev = node(index).prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node(index).prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node(index).next = null;
        }

        node(index).item = null;
        size--;
        return element;
    }

    public void clear() {
        for (MyLinkedList.Node<T> x = first; x != null; ) {
            MyLinkedList.Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return node(index).item;
    }

}
