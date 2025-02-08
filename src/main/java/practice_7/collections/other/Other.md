### **1️⃣ TreeMap** 🌳
📌 **Что это?**
- Реализация `Map`, основанная на **красно-чёрном дереве**.
- Ключи **хранятся в отсортированном порядке** (`Comparable` или `Comparator`).
- **Медленнее `HashMap`** (`O(log n)`, вместо `O(1)`).
- **Не позволяет `null` в качестве ключа**.

📌 **Чем отличается от `HashMap`?**  

| Функция | `HashMap` | `TreeMap` |
|---------|----------|----------|
| Основа | Хеш-таблица | Красно-чёрное дерево |
| Производительность | `O(1)` | `O(log n)` |
| Порядок ключей | ❌ Нет | ✅ Отсортирован |
| `null`-ключи | ✅ Можно | ❌ Нельзя |

📌 **Пример использования:**
```java
TreeMap<Integer, String> treeMap = new TreeMap<>();
treeMap.put(2, "B");
treeMap.put(1, "A");
treeMap.put(3, "C");
System.out.println(treeMap); // {1=A, 2=B, 3=C} (ключи упорядочены)
```

---

### **2️⃣ LinkedHashMap** 🔗
📌 **Что это?**
- **Гибрид `HashMap` + `LinkedList`**.
- **Запоминает порядок вставки ключей**.
- Производительность **как у `HashMap` (`O(1)`)**, но требует больше памяти.
- Используется, когда нужен **порядок + быстрая работа**.

📌 **Пример использования:**
```java
LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
linkedHashMap.put(2, "B");
linkedHashMap.put(1, "A");
linkedHashMap.put(3, "C");
System.out.println(linkedHashMap); // {2=B, 1=A, 3=C} (сохраняет порядок)
```

---

### **3️⃣ EnumMap** 🎭
📌 **Что это?**
- Оптимизированная версия `HashMap`, **только для `enum`-ключей**.
- Быстрее `HashMap`, так как использует **внутренний массив** вместо хеш-таблицы.

📌 **Пример использования:**
```java
enum Day { MONDAY, TUESDAY, WEDNESDAY }

EnumMap<Day, String> enumMap = new EnumMap<>(Day.class);
enumMap.put(Day.MONDAY, "Рабочий день");
System.out.println(enumMap.get(Day.MONDAY)); // "Рабочий день"
```

---

### **4️⃣ WeakHashMap** 🧹
📌 **Что это?**
- Реализация `Map`, где **ключи хранятся как `WeakReference`**.
- Если **на ключ больше нет ссылок, GC его удаляет**.
- Полезен для **кеширования и избежания утечек памяти**.

📌 **Пример использования:**
```java
WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
Object key = new Object();
weakMap.put(key, "value");
key = null; // Теперь ключ не удерживается
System.gc(); // Ключ и значение удалятся
```

---

### **5️⃣ IdentityHashMap** 🔍
📌 **Что это?**
- **Использует `==` вместо `equals()` для сравнения ключей**.
- Позволяет **хранить одинаковые объекты (по значению), но разные по ссылке**.
- Полезен для **низкоуровневых задач и кэширования**.

📌 **Пример использования:**
```java
IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();
String a = new String("key");
String b = new String("key");
identityMap.put(a, 1);
identityMap.put(b, 2);
System.out.println(identityMap); // {key=1, key=2} (разные объекты, даже если значение одинаковое)
```

---

### **6️⃣ PriorityQueue** 🏆
📌 **Что это?**
- Очередь (`Queue`), где элементы **упорядочены по приоритету**.
- Использует **двоичную кучу (Binary Heap)**.
- `poll()` возвращает **наименьший элемент** (если используется `Comparable`).
- `O(log n)` на вставку и удаление.

📌 **Пример использования:**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(3);
pq.offer(1);
pq.offer(2);
System.out.println(pq.poll()); // 1 (наименьший элемент)
```

---

### **7️⃣ ConcurrentHashMap** ⚡
📌 **Что это?**
- Потокобезопасная версия `HashMap`.
- **Разделяет данные на сегменты** (секции), что ускоряет работу.
- В отличие от `Collections.synchronizedMap()`, не блокирует всю карту.
- Используется в многопоточных приложениях.

📌 **Пример использования:**
```java
ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
concurrentMap.put("A", 1);
concurrentMap.put("B", 2);
System.out.println(concurrentMap); // {A=1, B=2}
```

---

### **8️⃣ CopyOnWriteArrayList / CopyOnWriteArraySet** ✍️
📌 **Что это?**
- `CopyOnWriteArrayList` и `CopyOnWriteArraySet` используются в многопоточных средах.
- При модификации создаётся **копия списка** (без блокировки чтения).
- Полезно, если **чтения больше, чем записей**.

📌 **Пример использования:**
```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
list.add("A");
list.add("B");
System.out.println(list); // [A, B]
```