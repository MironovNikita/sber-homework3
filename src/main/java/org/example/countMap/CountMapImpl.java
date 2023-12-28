package org.example.countMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private final Map<T, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(T object) {
        if (object != null) {
            int counter = map.getOrDefault(object, 0);
            map.put(object, counter + 1);
        }
    }

    @Override
    public int getCount(T object) {
        return map.getOrDefault(object, 0);
    }

    @Override
    public int remove(T object) {
        int counter = getCount(object);
        if (counter > 1) {
            map.put(object, counter - 1);
        } else map.remove(object);
        return counter;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        Map<? extends T, Integer> sourceMap = source.toMap();
        for (Map.Entry<? extends T, Integer> entry : sourceMap.entrySet()) {
            T key = entry.getKey();
            int counter = entry.getValue();
            int currentCounter = map.getOrDefault(key, 0);
            map.put(key, currentCounter + counter);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.clear();
        destination.putAll(map);
    }

    @Override
    public String toString() {
        return "countMap = " + map;
    }
}