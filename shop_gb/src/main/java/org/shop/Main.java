package org.shop;
import org.shop.shop.ProductDb;
import org.shop.shop.Manager;
import org.shop.view.ShopUI;

public class Main {
    public static void main(String[] args) {
        ProductDb db = new ProductDb();
        Manager manager = new Manager(db);
        ShopUI ShopUI = new ShopUI(manager);
        ShopUI.run();
    }
}