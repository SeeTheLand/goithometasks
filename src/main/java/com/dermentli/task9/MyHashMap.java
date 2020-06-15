package com.dermentli.task9;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap<T, K> implements Map<T,K>{

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public K put(T key, K value) {
        return putVal(hash(key), key, value, false, true);
    }

    static class Node<T,K> implements Map.Entry<T,K> {
        final int hash;
        final T key;
        K value;
        MyHashMap.Node<T,K> next;

        Node(int hash, T key, K value, MyHashMap.Node<T,K> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final T getKey()        { return key; }
        public final K getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final K setValue(K newValue) {
            K oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    final K putVal(int hash, T key, K value, boolean onlyIfAbsent,
                   boolean evict) {
        MyHashMap.Node<T,K>[] tab; MyHashMap.Node<T,K> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            MyHashMap.Node<T,K> e; T t;
            if (p.hash == hash &&
                    ((t = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof MyHashMap.TreeNode)
                e = ((MyHashMap.TreeNode<T,K>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((t = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

}
