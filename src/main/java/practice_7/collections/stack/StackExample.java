package practice_7.collections.stack;

import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        // 1️⃣ Создание стека
        Stack<Integer> stack = new Stack<>();
        System.out.println("Создан пустой Stack: " + stack);

        // 2️⃣ Добавление элементов
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("После push: " + stack); // [10, 20, 30]

        // 3️⃣ Получение верхнего элемента
        System.out.println("peek(): " + stack.peek()); // 30

        // 4️⃣ Удаление элемента
        System.out.println("pop(): " + stack.pop()); // 30
        System.out.println("После pop: " + stack); // [10, 20]

        // 5️⃣ Проверка пустоты
        System.out.println("Stack пуст? " + stack.empty()); // false

        // 6️⃣ Поиск элемента
        System.out.println("search(10): " + stack.search(10)); // 2 (от вершины)
        System.out.println("search(50): " + stack.search(50)); // -1 (нет в стеке)

        // 7️⃣ Использование `Deque` вместо `Stack`
        Deque<Integer> dequeStack = new ArrayDeque<>();
        dequeStack.push(100);
        dequeStack.push(200);
        dequeStack.push(300);
        System.out.println("DequeStack: " + dequeStack); // [300, 200, 100]

        // 8️⃣ `Deque` работает как стек
        System.out.println("Deque pop(): " + dequeStack.pop()); // 300
        System.out.println("Deque после pop: " + dequeStack); // [200, 100]

        // 9️⃣ Сравнение производительности `Stack` vs `Deque`
        Stack<Integer> stackPerf = new Stack<>();
        Deque<Integer> dequePerf = new ArrayDeque<>();

        long start, end;

        // Заполнение Stack
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stackPerf.push(i);
        }
        end = System.nanoTime();
        System.out.println("Stack: добавление 10k элементов = " + (end - start) / 1_000_000 + " мс");

        // Заполнение Deque
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            dequePerf.push(i);
        }
        end = System.nanoTime();
        System.out.println("Deque: добавление 10k элементов = " + (end - start) / 1_000_000 + " мс");
    }
}
