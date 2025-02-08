package practice_7.collections.priorityqueue;

import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // 1️⃣ Базовый PriorityQueue (по умолчанию - мин-куча)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(5);
        pq.offer(20);
        pq.offer(1);

        System.out.println("Минимальный элемент: " + pq.peek()); // 1

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // 1, 5, 10, 20
        }

        // 2️⃣ PriorityQueue с обратным порядком (максимальная куча)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);

        System.out.println(maxHeap.poll()); // 20 (самый большой)

        // 3️⃣ Очередь задач с приоритетом
        class Task {
            String name;
            int priority;

            public Task(String name, int priority) {
                this.name = name;
                this.priority = priority;
            }
        }

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(task -> task.priority));
        taskQueue.offer(new Task("Fix bug", 2));
        taskQueue.offer(new Task("Release update", 1));
        taskQueue.offer(new Task("Write docs", 3));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll().name); // "Release update", "Fix bug", "Write docs"
        }
    }
}
