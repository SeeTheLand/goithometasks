package com.dermentli.task9;

import java.util.HashMap;

public class MyHashMap<T,K> {
    //массив эллементов хеш таблицы типа типа Entry[], который является хранилищем ссылок на списки (цепочки) значений;
    transient MyHashMap.Node<T,K>[] table;
    // Коэффициент загрузки. Значение по умолчанию 0.75 является хорошим компромиссом между временем доступа и объемом хранимых данных;
    final float loadFactor;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //Предельное количество элементов, при достижении которого, размер хэш-таблицы увеличивается вдвое. Рассчитывается по формуле (capacity * loadFactor);
    int threshold;
    //Количество элементов HashMap-а;
    transient int size;


    //Зададим конструктор
    public MyHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.threshold = initialCapacity;
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    //нам понадобится ентри для хранения объектов
    static class Node<T,K> {

        Node(int hash, T key, K value, Node<T,K> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }

        final T key;
        K value;
        Node<T,K> next;
        final int hash;
    }

    //Хэш функция
    private int hash(T key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //Функция определения места в массиве
    private int indexFor(int hash, int size) {
        return hash & (size-1);
    }

    public K put(T key, K value) {
        if (key == null) return putForNullKey(value); //check key not 0
        int hash = hash(key); //calculating hash
        int i = indexFor(hash, table.length); //getting index
        for (MyHashMap.Node<T,K> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                K oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addNode(hash, key, value, i);
        return null;
    }

    void addNode(int hash, T key, K value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createNode(hash, key, value, bucketIndex);
    }

    private void resize(int newCapacity) {
        //to-do realization
    }

    //создаем грубо верхний элемент корзины, уоторый будет хранить ссылку на следующий
    void createNode(int hash, T key, K value, int bucketIndex) {
        MyHashMap.Node<T,K> e = table[bucketIndex];
        table[bucketIndex] = new MyHashMap.Node<>(hash, key, value, e);
        size++;
    }

    private K putForNullKey(K value) {
        for (MyHashMap.Node<T,K> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                K oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addNode(0, null, value, 0);
        return null;
    }

    public K remove(T key) {
        int hash = hash(key); //calculating hash
        int i = indexFor(hash, table.length); //getting index
        MyHashMap.Node<T,K> prevElement = null;
        for (Node<T,K> e = table[0]; e != null; e = e.next) {
            if (e.key == key) {
                prevElement.next = e.next;
                K oldValue = e.value;
                return oldValue;
            }
            prevElement = e;
        }
        return null;
    }

    public void clear() {
        MyHashMap.Node<T,K>[] tab;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    public final int size() {
        return size;
    }

    final MyHashMap.Node<T,K> get(T key) {
        if (size == 0) {
            return null;
        }

        int hash = (key == null) ? 0 : hash(key);
        for (MyHashMap.Node<T,K> e = table[indexFor(hash, table.length)];
            // Search through linked list
             e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

}
