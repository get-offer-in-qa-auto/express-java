package practice_7.restaraunt_manager;

public class Main {
    public static void main(String[] args) {
        RestaurantManager manager = new RestaurantManager();

        manager.addNewOrder("Картошка фри");
        manager.addNewOrder("Спагетти");
        manager.addNewOrder("Маргарита");
        manager.printOrders();

        manager.deleteOrder("Спагетти");
        manager.printOrders();
    }
}
