
# Обобщённые классы – Generics

В данном репозитории представлено выполнение заданий, касающихся обобщённых типов - дженериков.


## Что такое Generics?

***Дженерики (Generics)*** — это набор свойств языка Java, позволяющий определять и использовать обобщённые типы и методы.

Обобщённые типы или методы отличаются от обычных тем, что имеют типизированные параметры (**`T`** — параметр, в котором могут быть разные объекты).

Дженерики позволяют:

- уйти от жёсткого определения используемых типов;
- объявлять классы, интерфейсы и методы, где тип данных указан в виде параметра;
- создавать универсальные алгоритмы и структуры данных;
- осуществлять проверку на правильность написания кода во время компиляции, а не в Runtime.


## Задание №1

#### Параметризовать CountMap (из репозитория выше) и реализовать его.
```java
public interface CountMap {
    // добавляет элемент в этот контейнер.
    void add(Object o);

    //Возвращает количество добавлений данного элемента
    int getCount(Object o);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(Object o);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, 
    // при совпадении ключей,     суммировать значения
    void addAll(CountMap source);

    //Вернуть java.util.Map. ключ - добавленный элемент, 
    // значение - количество его добавлений
    Map toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map destination);
}
```

Пример использования: 
```java
CountMap<Integer> map = new CountMapImpl<>();

map.add(10);
map.add(10);
map.add(5);
map.add(6);
map.add(5);
map.add(10);

// int count = map.getCout(5);  // 2
// int count = map.getCout(6);  // 1
// int count = map.getCout(10); // 3
```

### Описание результатов
Интерфейс `CountMap` был параметризован. Затем был создан класс `CountMapImpl`, имплементирующий данный интерфейс с реализацией необходимой логики для работы с параметризованными типами.

Суть структуры данных заключается в том, что она хранит в себе элемент и количество данного элемента: **`private final Map<T, Integer> map;`**

В качестве элемента может быть любой объект `T`. При добавлении в `Map` создаётся запись, где ключом является сам объект, а в значение записывается его количество - 1.
В случае повторного добавления значение увеличится на 1. В случае удаления значение уменьшится на 1. При достижении значения 0 запись из `Map` удаляется.

Результат тестирования функционала представлен ниже:

![task1](https://github.com/MironovNikita/sber-homework3/blob/main/res/task1.png)

## Задание №2

#### Параметризовать методы, используя правило PECS, и реализовать их.

Правило **PECS** (**P**roducer **E**xtends, **C**onsumer **S**uper) в Java относится к использованию метасимвольных аргументов в дженериках (`Generics`). 🤖

_Producer Extends_ (производитель расширяет) указывает, что вы хотите использовать объекты только для чтения из коллекции, то есть они производят значения. Поэтому, в этом случае, вы можете использовать метасимвол ***"? extends Тип"*** в дженериках.

_Consumer Super_ (потребитель супер) указывает, что вы хотите использовать объекты только для записи в коллекцию, то есть они потребляют значения. В этом случае, вы можете использовать метасимвол ***"? super Тип"*** в дженериках.

Это правило используется для безопасной работы с дженериками в Java, чтобы предотвратить ошибки приведения типов. 🚀

#### Исходные данные
```java
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static List newArrayList() { }

    public static int indexOf(List source, Object o) { }

    public static List limit(List source, int size) { }

    public static void add(List source, Object o) { }

    public static void removeAll(List removeFrom, List c2) { }

    public static boolean containsAll(List c1, List c2) { }

    public static boolean containsAny(List c1, List c2) { }

    public static List range(List list, Object min, Object max) { }

    public static List range(List list, Object min, Object max, Comparator comparator) { }
}
```

Пояснения к некоторым методам.

```java
//true если первый лист содержит все элементы второго
public static boolean containsAll(List c1, List c2) {

}


//true если первый лист содержит хотя-бы 1 второго
public static boolean containsAny(List c1, List c2) {

}   


//Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max. 
// Элементы сравнивать через Comparable.
// Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
public static List range(List list, Object min, Object max) {
}


//Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max. 
// Элементы сравнивать через Comparable.
// Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
public static List range(List list, Object min, Object max, Comparator comparator) {
}
```

### Описание результатов
CollectionUtils представляет собой класс для работы со списками различных объектов:
- `public static<T> void addAll(List<? extends T> source, List<? super T> destination)` - позволяет добавить все элементы из списка `source` в список `destination`;
- `public static <T> List<T> newArrayList()` - позволяет создать новый список;
- `public static <T> int indexOf(List<? extends T> source, T object)` - позволяет найти индекс передаваемого объекта `object` в списке объектов `source`;
- `public static <T> List<T> limit(List<? extends T> source, int size)` - позволяет ограничить размер списка `source` до размера `size`. В случае, если переданный параметр `size` будет больше текущего размера списка, размер списка не изменится.
- `public static <T> void add(List<? super T> source, T object)` - позволяет добавить `object` в список `source`;
- `public static <T> void removeAll(List<? super T> removeFrom, Collection<? extends T> c2)` - позволяет удалить все элементы списка `c2` из списка `removeFrom`;
- `public static <T> boolean containsAll(List<? super T> c1, Collection<? extends T> c2)` - позволяет проверить, содержит ли список `с1` все элементы списка `c2`;
- `public static <T> boolean containsAny(Collection<? extends T> c1, Collection<? extends T> c2)` - позволяет проверить, содержит ли первый список `c1` хотя бы один элемент из второго списка `c2`;
- `public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max)` - позволяет вернуть список, содержащий элементы из входного листа `list` в диапазоне от `min` до `max`. Элементы сравниваются между собой через интерфейс **`Comparable`**.
- `public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator)` - позволяет вернуть список, содержащий элементы из входного листа `list` в диапазоне от `min` до `max`. Элементы сравниваются между собой через **`Comparator`**.

***Comparable*** делает наши объекты «сравнимыми» и создает для них наиболее естественный порядок сортировки, который будет использоваться в большинстве случаев.

***Comparator*** — это отдельный класс-«сравниватель».

Результат тестирования функционала представлен ниже:

![task2](https://github.com/MironovNikita/sber-homework3/blob/main/res/task2.png)