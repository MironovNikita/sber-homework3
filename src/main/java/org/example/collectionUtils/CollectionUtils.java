package org.example.collectionUtils;

import java.util.*;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T object) {
        return source.indexOf(object);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        return new ArrayList<>(source.subList(0, Math.min(size, source.size())));
    }

    public static <T> void add(List<? super T> source, T object) {
        source.add(object);
    }

    public static <T> void removeAll(List<? super T> removeFrom, Collection<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    //Т.к. мы записываем c1 в хешсет, то там нужен super. А так для обоих параметров метода подойдёт extends.
    //Записываем в HashSet для оптимального времени работы, т.к. интересуют только уникальные значения при поиске
    //одного массива в другом
    public static <T> boolean containsAll(List<? super T> c1, Collection<? extends T> c2) {
        return new HashSet<>(c1).containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(Collection<? extends T> c1, Collection<? extends T> c2) {
        for (T item : c2) {
            if (c1.contains(item)) return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6,4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {
        List<T> result = newArrayList();
        if (!containsAll(list, Arrays.asList(min, max))) {
            return newArrayList();
        }
        for (T item : list) {
            if (item.compareTo(min) >= 0 && item.compareTo(max) <= 0) {
                result.add(item);
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparator.
    // Пример range(Arrays.asList(8,1,3,5,6,4), 3, 6) вернет {3,4,5,6}
    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> result = newArrayList();
        for (T item : list) {
            if (comparator.compare(item, min) >=0 && comparator.compare(item, max) <= 0) {
                result.add(item);
            }
        }
        result.sort(comparator);
        return result;
    }
}
