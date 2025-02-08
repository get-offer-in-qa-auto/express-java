package practice_7.collections.hashmap;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        // 1️⃣ Создание HashMap
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("Создан пустой HashMap: " + map);

        // 2️⃣ Добавление элементов
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("A", 100); // Перезаписывает значение
        System.out.println("После добавлений: " + map); // {A=100, B=2, C=3}

        // 3️⃣ Получение значения
        System.out.println("get(A): " + map.get("A")); // 100

        // 4️⃣ Проверка наличия ключа
        System.out.println("containsKey(B): " + map.containsKey("B")); // true

        // 5️⃣ Удаление элемента
        map.remove("B");
        System.out.println("После удаления B: " + map); // {A=100, C=3}

        // 6️⃣ Перебор элементов
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
