# Разбор `LinkedList` в Java

## 📌 Введение
`LinkedList` — это двусвязный список в Java, реализующий интерфейсы:
- `List` — базовый интерфейс для списков.
- `Deque` — поддерживает очередь (`Queue`) и двустороннюю очередь (`Deque`).
- `Cloneable` — поддерживает клонирование.
- `Serializable` — можно сериализовать.

## 🔹 Основные характеристики `LinkedList`
- **Основан на узлах (`Node`)**, а не на массиве.
- **Двусвязная структура**:
  - Каждый узел хранит ссылку на **следующий** (`next`) и **предыдущий** (`prev`) элементы.
- **Производительность**:
  - Доступ по индексу `O(n)`, так как приходится **пройти список**.
  - Вставка/удаление в начало/конец `O(1)`.
  - Удаление из середины `O(n)`, если нет `ListIterator`.
- **Поддержка работы как **очередь (`Queue`)** и **стек (`Deque`)**.

---

## 🔹 Внутреннее устройство `LinkedList`
### 1️⃣ **Внутреннее хранение данных**
```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```
- Каждый узел (`Node`) хранит значение `item`, ссылку на **предыдущий (`prev`)** и **следующий (`next`)** узел.
- `first` и `last` хранят ссылки на начало и конец списка.

```java
transient Node<E> first;
transient Node<E> last;
```

### 2️⃣ **Конструкторы**
```java
public LinkedList() {
}
public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}
```
- `new LinkedList<>()` создаёт **пустой список**.
- `new LinkedList<>(Collection<? extends E> c)` копирует элементы из переданной коллекции.

### 3️⃣ **Добавление элемента**
#### 🔹 В конец списка (`addLast()`)
```java
void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
}
```
- Создаёт **новый узел**.
- Если список пуст, новый узел становится `first`.
- В противном случае обновляет `last`.

#### 🔹 В начало списка (`addFirst()`)
```java
void linkFirst(E e) {
    final Node<E> f = first;
    final Node<E> newNode = new Node<>(null, e, f);
    first = newNode;
    if (f == null)
        last = newNode;
    else
        f.prev = newNode;
    size++;
}
```
- Добавляет элемент **в начало списка**.
- Если список был пуст, новый узел становится `last`.

### 4️⃣ **Удаление элемента**
#### 🔹 Удаление с начала (`removeFirst()`)
```java
private E unlinkFirst(Node<E> f) {
    final E element = f.item;
    final Node<E> next = f.next;
    f.item = null;
    f.next = null; // Очистка ссылки
    first = next;
    if (next == null)
        last = null;
    else
        next.prev = null;
    size--;
    return element;
}
```
- Убирает ссылку на первый элемент.
- Если список становится пустым, `last = null`.

#### 🔹 Удаление с конца (`removeLast()`)
```java
private E unlinkLast(Node<E> l) {
    final E element = l.item;
    final Node<E> prev = l.prev;
    l.item = null;
    l.prev = null; // Очистка ссылки
    last = prev;
    if (prev == null)
        first = null;
    else
        prev.next = null;
    size--;
    return element;
}
```
- Убирает ссылку на последний элемент.
- Если список становится пустым, `first = null`.

---

## 🔹 Частые вопросы на собеседовании
### ❓ **Как устроен `LinkedList` внутри?**
Ответ:
- Это **двусвязный список** (`Node<E>`).
- Узлы (`Node`) содержат **ссылки на предыдущий и следующий элементы**.
- `first` указывает на **первый элемент**, `last` — на **последний**.

### ❓ **Чем `LinkedList` отличается от `ArrayList`?**
| Функция        | `ArrayList`   | `LinkedList`  |
|---------------|-------------|--------------|
| Доступ по индексу | `O(1)`       | `O(n)`        |
| Вставка в конец | `O(1)`       | `O(1)`        |
| Вставка в середину | `O(n)`       | `O(1)`, если есть `ListIterator` |
| Удаление элемента | `O(n)`       | `O(1)`, если есть `ListIterator` |

**Вывод**: `LinkedList` лучше, если нужно **часто удалять/добавлять в середину**.

### ❓ **Почему `LinkedList` медленный для поиска по индексу?**
Ответ:
- Доступ по индексу `O(n)`, так как приходится **перебирать узлы**.
- `get(int index)` начинает с `first` или `last`, двигаясь к нужному элементу.

```java
public E get(int index) {
    if (index < (size >> 1)) { // Если index ближе к началу
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;
    } else { // Если index ближе к концу
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x.item;
    }
}
```

### ❓ **Как реализован `remove(int index)`?**
Ответ:
- Если `index < size / 2`, идёт поиск **с начала списка**.
- Если `index > size / 2`, идёт поиск **с конца списка**.
- После нахождения узла, его удаляют и обновляют ссылки.

### ❓ **Как уменьшить размер `LinkedList` в памяти?**
Ответ:
- `LinkedList` не использует `trimToSize()`, как `ArrayList`.
- Единственный способ — пересоздать список:

```java
list = new LinkedList<>(list);
```

### ❓ **Можно ли хранить `null` в `LinkedList`?**
Ответ:
- Да, `LinkedList` поддерживает `null`-значения.

```java
List<String> list = new LinkedList<>();
list.add(null);
System.out.println(list.get(0)); // null
```

### ❓ **Как `LinkedList` поддерживает очередь и стек?**
Ответ:
- Использует интерфейс `Deque`, позволяя работать как:
    - **Очередь (FIFO)** → `addLast()`, `removeFirst()`.
    - **Стек (LIFO)** → `addFirst()`, `removeFirst()`.

---

## 🔹 Заключение
- `LinkedList` удобен для **частого удаления и добавления**.
- Использует **узлы (`Node<E>`)** вместо массива.
- Доступ по индексу **медленный (`O(n)`)**.
- Подходит для реализации **очереди (`Queue`)** и **стека (`Deque`)**.

---
**Автор**: Alex Pshe 🚀
