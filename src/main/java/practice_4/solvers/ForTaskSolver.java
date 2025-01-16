package practice_4.solvers;

public class ForTaskSolver {
    public static void main(String[] args) {
        // проверка таблицы умножения для числа
        //multiplyTable(5);

        // проверка суммы всех чисел до числа
        // System.out.println(sumOfAllNumber(10));

        // проверка метода по определению простого числа
        // System.out.println(checkNumberIsSimple(7));
        // System.out.println(checkNumberIsSimple(6));

        // проверка метода по распечатки всех простых чисел до 100
        printAllSimpleNumbersBefore100();
    }

    public static void multiplyTable(int number) {
        for (int i = 1; i <= 10;i++) {
             System.out.println(
                     number + " x " + i + " = " + number * i);
        }
    }

    public static int sumOfAllNumber(int n) {
        int sum = 0;

        // Шаг 1: sum = 0; i = 1 -> sum = 1
        // Шаг 2: sum = 1; i = 2 -> sum = 3
        // Шаг 3: sum = 3; i = 3 -> sum = 6
        // Шаг 4: sum = 6; i = 4 -> sum = 10

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static boolean checkNumberIsSimple(int number) {
        // простое число - это число, которое делится на себя и на 1
        // 7 - 7,1
        // Как понять, что число простое?
        // необходимо пройтись от 2 до number-1 и проверить, есть ли хотя бы 1 число при делении на которое мы получаем остаток 0, то НЕ простое

        // Пример: 7
        // 2, 3, 4, 5, 6 -> простое

        // Пример: 6
        // 2 -> не простое
        boolean isSimple = true;

        for (int i = 2; i <= number-1; i++) {
            if (number % i == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }

    public static void printAllSimpleNumbersBefore100() {
        for (int i = 2; i <=100; i++) {
            if (checkNumberIsSimple(i)) {
                System.out.println(i);
            }
        }
    }
}
