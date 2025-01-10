package practice_2;

public class Main {
    public static void main(String[] args) {
        // проверка конструктора по умолчанию
        Student petya = new Student(18, "Петя");

        petya.print();

        Student kolya = new Student(20, "Коля");

        kolya.print();

        petya.name = "Aнтон";
        petya.print();

        kolya.age = 21;
        kolya.print();

        // дебаггинг или дебаг, точка ОСТАНОВА
    }
}
