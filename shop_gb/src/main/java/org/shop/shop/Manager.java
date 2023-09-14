package org.shop.shop;

import org.shop.exceptions.ProductDbEx;
import org.shop.exceptions.ManagerEx;

import java.util.List;

public class Manager {
    private final ProductDb db;

    public Manager(ProductDb db) {
        this.db = db;
    }

    public double purchaseProduct(int productId, int quantity) throws ManagerEx, ProductDbEx {
        Product product = db.getProduct(productId);
        if (product.getAvailableQuantity() < quantity) {
            throw new ManagerEx("Не достаточное количество в магазине");
        }
        double totalPrice = product.getPrice() * quantity;
        db.reduceProductQuantity(product, quantity);
        return totalPrice;
    }

    public List<Product> getAllProducts() {
        return db.getStock();
    }

}
