# Разбор `Queue` в Java

## 📌 Введение
`Queue` — это интерфейс в Java, представляющий **очередь (FIFO — First In, First Out)**. Основные реализации:
- `LinkedList` — **двусвязный список**, поддерживает `Queue` и `Deque`.
- `ArrayDeque` — **быстрая реализация очереди**, лучше `LinkedList`.
- `PriorityQueue` — **очередь с приоритетом**, элементы упорядочены по `Comparable` или `Comparator`.

## 🔹 Основные характеристики `Queue`
- **Работает по принципу FIFO** (первый добавленный элемент извлекается первым).
- **Очередь может быть ограниченной** (например, `ArrayBlockingQueue`).
- **Разные типы очередей**:
  - **Обычная очередь** (`LinkedList`, `ArrayDeque`).
  - **Приоритетная очередь** (`PriorityQueue`).
  - **Блокирующая очередь** (`BlockingQueue`, `ConcurrentLinkedQueue`).

---

## 🔹 Внутреннее устройство `Queue`
### 1️⃣ **Как устроена очередь?**
- **Очередь основана на `LinkedList` или `ArrayDeque`**.
- **Методы FIFO**:
  - `offer()` — добавить элемент.
  - `poll()` — удалить и вернуть элемент.
  - `peek()` — получить элемент без удаления.

### 2️⃣ **Основные методы `Queue`**
| Метод | Описание |
|--------|-------------|
| `offer(E e)` | Добавляет элемент (не бросает исключение) |
| `poll()` | Удаляет и возвращает первый элемент (`null`, если пусто) |
| `peek()` | Возвращает первый элемент без удаления (`null`, если пусто) |
| `remove()` | Удаляет первый элемент (бросает `NoSuchElementException`, если пусто) |
| `element()` | Возвращает первый элемент без удаления (бросает исключение) |

---

## 🔹 Описание методов `Queue`
### 1️⃣ **Добавление элемента (`offer()`, `add()`)**
```java
public boolean offer(E e) {
    return linkLast(e);
}
public boolean add(E e) {
    if (offer(e))
        return true;
    else
        throw new IllegalStateException("Queue full");
}
```
- `offer()` **безопасен** — если очередь заполнена, **возвращает `false`**.
- `add()` бросает **`IllegalStateException`**, если очередь переполнена.

### 2️⃣ **Удаление элемента (`poll()`, `remove()`)**
```java
public E poll() {
    return (size == 0) ? null : unlinkFirst();
}
public E remove() {
    E x = poll();
    if (x != null)
        return x;
    else
        throw new NoSuchElementException();
}
```
- `poll()` возвращает `null`, если очередь **пуста**.
- `remove()` бросает `NoSuchElementException`, если очередь **пуста**.

### 3️⃣ **Получение элемента (`peek()`, `element()`)**
```java
public E peek() {
    return (size == 0) ? null : first.item;
}
public E element() {
    E x = peek();
    if (x != null)
        return x;
    else
        throw new NoSuchElementException();
}
```
- `peek()` возвращает `null`, если очередь **пуста**.
- `element()` бросает `NoSuchElementException`, если очередь **пуста**.

---

## 🔹 Частые вопросы на собеседовании
### ❓ **Как работает `Queue` в Java?**
Ответ:
- Интерфейс `Queue` реализует **FIFO**.
- Основные методы:
    - `offer()` — добавить.
    - `poll()` — удалить.
    - `peek()` — посмотреть первый элемент.

### ❓ **Чем `Queue` отличается от `Stack`?**
| Функция | `Queue` (FIFO) | `Stack` (LIFO) |
|---------|--------------|--------------|
| Удаление | `poll()` (первый) | `pop()` (последний) |
| Получение | `peek()` | `peek()` |
| Реализация | `LinkedList`, `ArrayDeque` | `Stack`, `ArrayDeque` |

### ❓ **Чем `LinkedList` и `ArrayDeque` отличаются как `Queue`?**
| Функция | `LinkedList` | `ArrayDeque` |
|---------|-------------|-------------|
| Производительность | Медленнее (связный список) | Быстрее (массив) |
| Потокобезопасность | Нет | Нет |
| Предпочтение | ❌ Не рекомендуется | ✅ Лучше использовать |

### ❓ **Что такое `PriorityQueue`?**
Ответ:
- Очередь, в которой элементы **упорядочены**.
- Основана на **двоичной куче (binary heap)**.
- `poll()` извлекает **наименьший элемент** (`Comparable` или `Comparator`).

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(3);
pq.offer(1);
pq.offer(2);
System.out.println(pq.poll()); // 1 (наименьший элемент)
```

---

## 🔹 Заключение
- `Queue` реализует **FIFO**.
- `LinkedList` и `ArrayDeque` чаще всего используются.
- `PriorityQueue` сортирует элементы.
- Лучше использовать **`ArrayDeque` вместо `LinkedList`**.

---
**Автор**: Alex Pshe 🚀