package org.example.collectionUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №2. Преобразовать методы (CollectionUtils), используя правило PECS и реализовать их.\n");

        List<Integer> source1 = new ArrayList<>(List.of(1, 2, 3, 100));
        List<Double> source2 = new ArrayList<>(List.of(456.0, 89.0, 2.0, 8.1, 90.8, 65.55));
        List<Integer> destination1 = CollectionUtils.newArrayList();
        List<Double> destination2 = CollectionUtils.newArrayList();

        System.out.println("Проверка метода \"addAll(source, destination)\"");
        CollectionUtils.addAll(source1, destination1);
        CollectionUtils.addAll(source2, destination2);

        System.out.println("Вывод итогового массива Integer: " + destination1);
        System.out.println("Вывод итогового массива Double: " + destination2);

        System.out.println("Индекс числа \"3\" в коллекции <Integer> destination: " +
                CollectionUtils.indexOf(destination1, 3));
        System.out.println("Индекс числа \"456\" в коллекции <Double> destination: " +
                CollectionUtils.indexOf(destination2, 456.0));

        System.out.println("\nПроверка метода \"limit\"");
        System.out.println("Размер массива source1 до уменьшения: " + source1.size() + " - " + source1);
        source1 = CollectionUtils.limit(source1, 2);
        System.out.println("Размер массива source1 после уменьшения: " + source1.size() + " - " + source1);
        System.out.println("Размер массива source2 до уменьшения: " + source2.size() + " - " + source2);
        source2 = CollectionUtils.limit(source2, 1);
        System.out.println("Размер массива source2 после уменьшения: " + source2.size() + " - " + source2);
        source2 = CollectionUtils.limit(source2, 10); //проверка на ошибку, если size превышает размер исходного массива

        System.out.println("\nПроверка метода \"add\"");
        List<Integer> listToAdd1 = CollectionUtils.newArrayList();
        List<Float> listToAdd2 = CollectionUtils.newArrayList();
        CollectionUtils.add(listToAdd1, 10);
        CollectionUtils.add(listToAdd2, 15.897F);
        CollectionUtils.add(listToAdd1, 1);
        CollectionUtils.add(listToAdd2, 93.1F);
        CollectionUtils.add(listToAdd2, 100000F);
        CollectionUtils.add(listToAdd1, 19);
        System.out.println("Список чисел <Integer>: " + listToAdd1);
        System.out.println("Список чисел <Float>: " + listToAdd2);

        System.out.println("\nПроверка метода \"removeAll\"");
        Set<Integer> setToRemoveAll = new HashSet<>();

        setToRemoveAll.add(10);
        setToRemoveAll.add(1);
        setToRemoveAll.add(22);

        System.out.println("Удалим все имеющиеся здесь Integer " + setToRemoveAll + " из <Integer> listToAdd: " +
                listToAdd1);
        CollectionUtils.removeAll(listToAdd1, setToRemoveAll);
        System.out.println("Наш listToAdd стал: " + listToAdd1);

        System.out.println("\nПроверка метода \"containsAll\"");
        List<Long> numbersSearchFrom = new ArrayList<>(List.of(6L, 7L, 8L, 9L, 10L, 1L, 2L, 3L, 4L, 5L));
        Set<Long> numbersToSearch1 = new HashSet<>();
        for (int i = 3; i <= 7; i++) {
            numbersToSearch1.add((long) i);
        }
        Set<Long> numbersToSearch2 = new HashSet<>();
        for (int i = 12; i >= 7; i--) {
            numbersToSearch2.add((long) i);
        }

        System.out.println("Ищем весь " + numbersToSearch1 + " в " + numbersSearchFrom);
        System.out.println("Результат: " + CollectionUtils.containsAll(numbersSearchFrom, numbersToSearch1)); //true
        System.out.println("Ищем весь " + numbersToSearch2 + " в " + numbersSearchFrom);
        System.out.println("Результат: " + CollectionUtils.containsAll(numbersSearchFrom, numbersToSearch2)); //false

        System.out.println("\nПроверка метода \"containsAny\"");
        Set<Integer> setOfInteger = new HashSet<>();
        setOfInteger.add(34);
        setOfInteger.add(9);
        setOfInteger.add(28);
        setOfInteger.add(2);
        setOfInteger.add(274);

        List<Integer> listOfInteger = CollectionUtils.newArrayList();
        listOfInteger.add(28);
        listOfInteger.add(64);

        System.out.println("\nИскомый массив: " + setOfInteger);
        System.out.println("Массив элементов: " + listOfInteger);
        System.out.println("Содержит ли массив элементов хотя бы 1 элемент в искомом: "
                + CollectionUtils.containsAny(setOfInteger, listOfInteger));

        System.out.println("\nПроверка метода \"range(List<T> list, T min, T max)\"");
        List<Integer> rangeFirstCheck = Arrays.asList(8, 1, 3, 5, 6, 4);
        System.out.println("Проверяем массив: " + rangeFirstCheck);
        System.out.println("Диапазон значений должен быть между 3 и 6: " +
                CollectionUtils.range(rangeFirstCheck, 3, 6));

        System.out.println("\nПроверка метода \"range(List<T> list, T min, T max, Comparator<? super T> comparator)\"");
        List<Integer> rangeSecondCheck = Arrays.asList(8, 1, 3, 5, 6, 4);

        System.out.println("Проверяем массив: " + rangeSecondCheck);
        System.out.println("Диапазон значений должен быть между 3 и 6: " +
                CollectionUtils.range(rangeSecondCheck, 3, 6, Integer::compareTo));
    }
}
