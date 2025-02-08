package practice_7.collections.linkedlist;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        // 1️⃣ Создание LinkedList
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Создан пустой LinkedList: " + list);

        // 2️⃣ Добавление элементов
        list.add("A");    // В конец списка
        list.addFirst("B"); // В начало
        list.addLast("C");  // В конец
        list.add(1, "D");   // Вставка на позицию 1
        System.out.println("После добавлений: " + list); // [B, D, A, C]

        // 3️⃣ Удаление элементов
        list.remove("D"); // Удаление по значению
        list.remove(1);   // Удаление по индексу
        list.removeFirst(); // Удаление первого элемента
        list.removeLast();  // Удаление последнего элемента
        System.out.println("После удалений: " + list); // []

        // 4️⃣ Работа как очередь (FIFO)
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);  // Добавление в конец
        queue.offer(2);
        queue.offer(3);
        System.out.println("Очередь (FIFO): " + queue); // [1, 2, 3]
        System.out.println("Удалён элемент: " + queue.poll()); // 1
        System.out.println("Очередь после удаления: " + queue); // [2, 3]

        // 5️⃣ Работа как стек (LIFO)
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(10); // Добавление в начало (как в стеке)
        stack.push(20);
        stack.push(30);
        System.out.println("Стек (LIFO): " + stack); // [30, 20, 10]
        System.out.println("Удалён элемент: " + stack.pop()); // 30
        System.out.println("Стек после удаления: " + stack); // [20, 10]

        // 6️⃣ Доступ к элементам
        LinkedList<String> accessList = new LinkedList<>(Arrays.asList("X", "Y", "Z"));
        System.out.println("Первый элемент: " + accessList.getFirst()); // X
        System.out.println("Последний элемент: " + accessList.getLast()); // Z
        System.out.println("Элемент по индексу 1: " + accessList.get(1)); // Y

        // 7️⃣ Итерирование по списку
        System.out.print("Итерирование по LinkedList: ");
        for (String item : accessList) {
            System.out.print(item + " "); // X Y Z
        }
        System.out.println();

        // 8️⃣ Использование ListIterator для двустороннего обхода
        ListIterator<String> iterator = accessList.listIterator();
        System.out.print("Прямой обход: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // X Y Z
        }
        System.out.println();

        System.out.print("Обратный обход: ");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " "); // Z Y X
        }
        System.out.println();

        // 9️⃣ Сравнение ArrayList и LinkedList на вставку в начало
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start, end;

        // Вставка в начало (ArrayList)
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList: вставка в начало 10k элементов = " + (end - start) / 1_000_000 + " мс");

        // Вставка в начало (LinkedList)
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList: вставка в начало 10k элементов = " + (end - start) / 1_000_000 + " мс");

        // 🔟 Удаление всех элементов
        linkedList.clear();
        System.out.println("После очистки: " + linkedList); // []

        // 1️⃣1️⃣ LinkedList с null-значениями
        LinkedList<String> nullList = new LinkedList<>();
        nullList.add(null);
        nullList.add("Hello");
        nullList.add(null);
        System.out.println("LinkedList с null: " + nullList); // [null, Hello, null]

        // 1️⃣2️⃣ Создание списка из другой коллекции
        Set<String> set = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        LinkedList<String> fromSet = new LinkedList<>(set);
        System.out.println("LinkedList из Set: " + fromSet); // Порядок может быть случайным

        // 1️⃣3️⃣ Двумерный LinkedList (список списков)
        LinkedList<LinkedList<Integer>> matrix = new LinkedList<>();
        matrix.add(new LinkedList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new LinkedList<>(Arrays.asList(4, 5, 6)));
        System.out.println("Двумерный LinkedList: " + matrix); // [[1, 2, 3], [4, 5, 6]]
    }
}

