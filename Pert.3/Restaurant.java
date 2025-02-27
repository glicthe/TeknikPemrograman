// Kelas Restaurant

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends RestaurantMain{
    private String name;
    private List<Menu> menuList;

    public Restaurant(String name) {
        this.name = name;
        this.menuList = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    public void displayMenu() {
        System.out.println("Menu di " + name + ":");
        for (Menu menu : menuList) {
            System.out.println(menu.getName() + " - Harga: " + menu.getPrice());
        }
    }

    public void orderFood(String menuName) {
        for (Menu menu : menuList) {
            if (menu.getName().equalsIgnoreCase(menuName)) {
                if (menu.getStock() > 0) {
                    menu.decreaseStock();
                    System.out.println("Pesanan berhasil: " + menuName);
                    return;
                } else {
                    System.out.println("Stok habis untuk: " + menuName);
                    return;
                }
            }
        }
        System.out.println("Menu tidak ditemukan: " + menuName);
    }
}

