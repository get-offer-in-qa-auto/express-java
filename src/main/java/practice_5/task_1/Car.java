package practice_5.task_1;

public class Car extends Transport {
    public Car() {
        super(70, 4);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void start() {
        System.out.println("Машина поехала");
    }
}
