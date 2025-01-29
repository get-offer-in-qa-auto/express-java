package practice_8.errors;

public class StackOverflowError {
    public static void recursivePrint(int num) {
        System.out.println(num);
        recursivePrint(num + 1); // рекурсивный вызов без условия выхода
    }

    public static void main(String[] args) {
        recursivePrint(1);
    }
}
