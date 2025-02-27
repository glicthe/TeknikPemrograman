public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Restoran Sehat");
        restaurant.addMenu(new Menu("Bala-Bala", 1000, 20));
        restaurant.addMenu(new Menu("Gehu", 1000, 20));
        restaurant.addMenu(new Menu("Tahu", 1000, 0));
        restaurant.addMenu(new Menu("Molen", 1000, 20));

        restaurant.displayMenu();
        restaurant.orderFood("Bala-Bala");
        restaurant.orderFood("Gehu");
        restaurant.orderFood("Tahu");
        restaurant.orderFood("Molen");
        restaurant.orderFood("Pizza");
    }
}

