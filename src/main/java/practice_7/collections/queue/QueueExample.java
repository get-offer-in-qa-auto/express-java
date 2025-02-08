package practice_7.collections.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueExample {
    public static void main(String[] args) {
        // 1️⃣ Очередь на LinkedList
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println("Очередь: " + queue); // [A, B, C]

        // 2️⃣ Извлечение элементов
        System.out.println("poll(): " + queue.poll()); // A
        System.out.println("peek(): " + queue.peek()); // B

        // 3️⃣ Очередь на ArrayDeque (быстрее)
        Queue<Integer> arrayQueue = new ArrayDeque<>();
        arrayQueue.offer(10);
        arrayQueue.offer(20);
        arrayQueue.offer(30);
        System.out.println("ArrayDeque queue: " + arrayQueue); // [10, 20, 30]

        // 4️⃣ PriorityQueue (очередь с приоритетом)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        System.out.println("PriorityQueue: " + pq); // [1, 3, 2] (наименьший элемент первым)
        System.out.println("poll() из PriorityQueue: " + pq.poll()); // 1

        // 5️⃣ Очередь с ограниченным размером
        Queue<Integer> limitedQueue = new ArrayBlockingQueue<>(3);
        limitedQueue.offer(100);
        limitedQueue.offer(200);
        limitedQueue.offer(300);
        System.out.println("Ограниченная очередь: " + limitedQueue); // [100, 200, 300]
        System.out.println("Попытка добавить 400: " + limitedQueue.offer(400)); // false

        // 6️⃣ ConcurrentLinkedQueue (потокобезопасная)
        Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
        concurrentQueue.offer("X");
        concurrentQueue.offer("Y");
        System.out.println("ConcurrentQueue: " + concurrentQueue);
    }
}
