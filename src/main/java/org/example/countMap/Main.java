package org.example.countMap;

import org.example.countMap.CountMap;
import org.example.countMap.CountMapImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1. Параметризовать CountMap и реализовать его.\n");
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.add(30);
        map.add(20);


        System.out.println("Размер текущей CountMap: " + map.size());

        System.out.println("Посчитаем количество элементов для \"5\": " + map.getCount(5)); // 2
        System.out.println("Посчитаем количество элементов для \"6\": " + map.getCount(6)); // 1
        System.out.println("Посчитаем количество элементов для \"10\": " + map.getCount(10)); // 3

        System.out.println("\nПроверим удаление элемента \"5\"");
        System.out.println("Количество элемента \"5\" до удаления: " + map.remove(5));
        System.out.println(map);
        System.out.println("Размер текущей CountMap: " + map.size());

        System.out.println("\nПроверим удаление элемента \"6\"");
        System.out.println("Количество элемента \"6\" до удаления: " + map.remove(6));
        System.out.println(map);
        System.out.println("Размер текущей CountMap: " + map.size());

        System.out.println("\nПроверим метод \"addAll\"");
        CountMap<Integer> newMap = new CountMapImpl<>();
        newMap.add(10);
        newMap.add(20);
        newMap.add(6);
        newMap.add(10);
        newMap.add(7);
        newMap.add(30);

        map.addAll(newMap);
        System.out.println("Текущий CountMap - " + map); //10 = 5, 20 = 2, 6 = 1, 7 = 1, 30 = 2
        System.out.println("Размер текущей CountMap: " + map.size()); //6

        System.out.println("\nПроверка методов \"toMap()\" и \"toMap(Map<T, Integer> destination)\"");
        System.out.println("Текущий CountMap - " + map);
        Map<Integer, Integer> toMapCheckMap = map.toMap();
        System.out.println("Map toMapCheckMap после \"map.toMap()\" - " + toMapCheckMap);

        Map<Integer, Integer> toCheckMap = new HashMap<>();
        map.toMap(toCheckMap);
        System.out.println("Map tocheckMap после \"map.toMap(toCheckMap)\" - " + toCheckMap);
    }
}