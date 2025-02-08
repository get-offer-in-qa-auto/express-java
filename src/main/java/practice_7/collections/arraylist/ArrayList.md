# Разбор `ArrayList` в Java

## 📌 Введение
`ArrayList` — это динамический массив в Java, который автоматически изменяет размер при добавлении или удалении элементов. Он реализует интерфейсы:
- `List` — базовый интерфейс для работы со списками.
- `RandomAccess` — указывает, что доступ к элементам `O(1)`.
- `Cloneable` — поддерживает клонирование.
- `Serializable` — можно сериализовать.

## 🔹 Основные характеристики `ArrayList`
- **Основан на массиве** (`Object[] elementData`).
- **Динамическое изменение размера** (увеличивается в 1.5 раза при заполнении).
- **Производительность**:
  - Доступ по индексу `O(1)`.
  - Вставка в конец `O(1)`, если не требуется расширение.
  - Вставка/удаление из середины `O(n)`, так как требует сдвига элементов.
- **Не потокобезопасный** (если нужна потокобезопасность, используй `Collections.synchronizedList()` или `CopyOnWriteArrayList`).

---

## 🔹 Внутреннее устройство `ArrayList`
### 1️⃣ **Внутреннее хранение данных**
```java
transient Object[] elementData;
```
- Это массив, в котором хранятся все элементы списка.
- В JDK 9+ пустые `ArrayList` используют `DEFAULTCAPACITY_EMPTY_ELEMENTDATA` до первого `add()`.

### 2️⃣ **Конструкторы**
```java
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```
- `new ArrayList<>()` создаёт список с пустым массивом.
- `new ArrayList<>(initialCapacity)` сразу выделяет массив указанного размера.
- `new ArrayList<>(Collection<? extends E> c)` копирует элементы переданной коллекции.

### 3️⃣ **Добавление элемента**
```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);
    elementData[size++] = e;
    return true;
}
```
- Проверяет, достаточно ли места в `elementData[]`.
- Если массив полон, вызывается `grow()`.

### 4️⃣ **Расширение массива (`grow()`)**
```java
private void grow(int minCapacity) {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1); // Увеличение в 1.5 раза
    if (newCapacity < minCapacity)
        newCapacity = minCapacity;
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```
- Размер увеличивается **в 1.5 раза**.
- Используется `Arrays.copyOf()`, который копирует старый массив в новый.

### 5️⃣ **Удаление элемента**
```java
public E remove(int index) {
    E oldValue = elementData(index);
    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
    elementData[--size] = null;
    return oldValue;
}
```
- Удаляет элемент и сдвигает остальные `System.arraycopy()`.
- Последний элемент **обнуляется** для очистки ссылки.

### 6️⃣ **Очистка списка**
```java
public void clear() {
    for (int i = 0; i < size; i++)
        elementData[i] = null;
    size = 0;
}
```
- Обнуляет все ссылки в массиве (чтобы GC мог их убрать).
- `size` обнуляется.

---

## 🔹 Частые вопросы на собеседовании
### ❓ **Как устроен `ArrayList` внутри?**
Ответ:
- Основан на массиве `Object[] elementData`.
- При переполнении увеличивается в 1.5 раза.
- Удаление требует сдвига элементов `System.arraycopy()`.

### ❓ **Как `ArrayList` увеличивает размер?**
Ответ:
- При добавлении элемента проверяется `ensureCapacityInternal(size + 1)`.
- Если массив заполнен, вызывается `grow()`, который увеличивает размер в **1.5 раза**.

### ❓ **В чем разница `ArrayList` и `LinkedList`?**
| Функция        | `ArrayList`   | `LinkedList`  |
|---------------|-------------|--------------|
| Вставка в конец | `O(1)`       | `O(1)`        |
| Вставка в середину | `O(n)`       | `O(1)`, если есть `ListIterator` |
| Удаление элемента | `O(n)`       | `O(1)` (если есть ссылка) |
| Доступ по индексу | `O(1)`       | `O(n)` |

**Вывод**: `ArrayList` быстрее, если нужен **случайный доступ**. `LinkedList` лучше для **вставки/удаления в середину**.

### ❓ **Почему `ArrayList` не потокобезопасный?**
Ответ:
- `ArrayList` не синхронизирован (`add()` и `remove()` не используют `synchronized`).
- Если несколько потоков добавляют элементы, возможны гонки данных.

**Решение**:
- Использовать `Collections.synchronizedList(new ArrayList<>())`.
- Использовать `CopyOnWriteArrayList` (эффективен при редких изменениях).

### ❓ **Что произойдет, если в `ArrayList` добавить `null`?**
Ответ:
- `null` разрешен как значение.
- `ArrayList` не выбросит `NullPointerException`, в отличие от `HashMap`.

```java
List<String> list = new ArrayList<>();
list.add(null);
System.out.println(list.get(0)); // null
```

### ❓ **Какой начальный размер `ArrayList`?**
Ответ:
- `new ArrayList<>()` создаёт **пустой массив**.
- При первом `add()` размер увеличивается до **10** (в JDK 9+ жестко задано `10` в `calculateCapacity()`).

### ❓ **Как уменьшить размер `ArrayList` после удаления элементов?**
Ответ:
- Вызвать `trimToSize()`, чтобы уменьшить `elementData[]` до `size`.

```java
list.trimToSize();
```
- Это освобождает память, если список редко изменяется.

---

## 🔹 Заключение
- `ArrayList` удобен для **частого чтения и редкого удаления**.
- Расширяется **в 1.5 раза**, удаление требует **сдвига элементов**.
- Не потокобезопасен (используй `Collections.synchronizedList()`).
- Начальный размер **10** (если `add()` вызывается впервые).

**Полезно знать на собеседовании**:
- Как устроено добавление и удаление.
- В чем разница между `ArrayList` и `LinkedList`.
- Как `grow()` расширяет массив.
- Почему `trimToSize()` полезен.

---
**Автор**: Alex Pshe 🚀
