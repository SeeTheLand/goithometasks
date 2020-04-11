package com.dermentli.task3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CountRepeatingElements {

    public Map<Object, AtomicInteger> countRepeatingElements(int[] inputArray) {
        ConcurrentMap<Object, AtomicInteger> output = new ConcurrentHashMap<Object, AtomicInteger>();
        for (Object i : inputArray) {
            output.putIfAbsent(i, new AtomicInteger(0));
            output.get(i).incrementAndGet();
        }
        return output;
    }
}
