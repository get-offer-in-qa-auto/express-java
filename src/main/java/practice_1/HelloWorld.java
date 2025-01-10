package practice_1;
public class HelloWorld {
    // поля
     static int a = 1;

    // методы

    // зеленая стрелочка - программа запускаема
    // метод main - точкой входа в программу
    public static void main(String[] args) {
        final int sum1 = sum(1001, 2000);
        System.out.println("Результат сложения " + sum1);

        int mult1 = multiply(3, 2);
        System.out.println("Результат умножения " + mult1);

        int subs1 = substruct(10, 3);
        System.out.println("Результат вычитания " + subs1);

        double div1 = divide(3, 2);
        System.out.println("Результат деления " + div1);
    }

    public static int sum(int x, int y) {
        // тело метода
        return x + y; // возвращаемое значение из метода
    }

    public static int multiply(int p, int k) { //  аргументами метода
        // тело метода
        int mult = p * k; // cоздала переменную, присвоила значения равное результату
        // умножения p и k

        return mult;
    }

    public static int substruct(int g, int l) {
        return g - l;
    }

    // возвращаемый тип данных - целое или нет? 3/2 = 1.5
    public static double divide(int s, int h) {
        return (double) s / h;
    }
}

