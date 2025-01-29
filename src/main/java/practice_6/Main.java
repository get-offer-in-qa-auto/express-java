package practice_6;

public class Main {
    public static void main(String[] args) {
        Person nikita = new Person("Никита", 25);

        // Значение toString по умолчанию
        System.out.println(nikita.toString());

        // Cравнение объектов
        // примитивные типы данных сравниваются через ==
        // ссылочные типы данных сравниваются через equals
        Person nikita2 = new Person("Никита", 25);

        System.out.println(nikita.equals(nikita2));

        // Клонирование
        Person cloneNikita = nikita.clone();
        System.out.println(cloneNikita.toString());
    }
}
