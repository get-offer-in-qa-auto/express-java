package practice_7.collections.arraylist;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        // 1️⃣ Стандартный пустой список (массив создаётся при первом add)
        List<String> list1 = new java.util.ArrayList<>();
        System.out.println("list1 size: " + list1.size()); // 0
        list1.add("A");
        System.out.println("list1 after adding: " + list1); // [A]

        // 2️⃣ Список с указанной вместимостью
        List<Integer> list2 = new java.util.ArrayList<>(5);
        System.out.println("list2 size: " + list2.size()); // 0 (но память под 5 элементов выделена)
        list2.add(100);
        System.out.println("list2: " + list2); // [100]

        // 3️⃣ Создание списка из другой коллекции
        List<String> existingList = Arrays.asList("X", "Y", "Z");
        List<String> list3 = new java.util.ArrayList<>(existingList);
        System.out.println("list3: " + list3); // [X, Y, Z]

        // 4️⃣ Создание списка из множества (HashSet)
        Set<String> set = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        List<String> list4 = new java.util.ArrayList<>(set);
        System.out.println("list4: " + list4); // Порядок элементов может быть разным!

        // 5️⃣ Создание неизменяемого списка (Java 9+)
        List<String> list5 = List.of("Apple", "Banana", "Cherry");
        System.out.println("list5: " + list5); // [Apple, Banana, Cherry]
        // list5.add("Mango"); // Ошибка! UnsupportedOperationException

        // 6️⃣ Использование `Collections.nCopies()` для создания списка с N одинаковыми элементами
        List<String> list6 = new java.util.ArrayList<>(Collections.nCopies(5, "Hello"));
        System.out.println("list6: " + list6); // [Hello, Hello, Hello, Hello, Hello]

        // 7️⃣ Двумерный ArrayList (список списков)
        List<List<Integer>> list7 = new java.util.ArrayList<>();
        list7.add(new java.util.ArrayList<>(Arrays.asList(1, 2, 3)));
        list7.add(new java.util.ArrayList<>(Arrays.asList(4, 5, 6)));
        System.out.println("list7: " + list7); // [[1, 2, 3], [4, 5, 6]]
    }
}

