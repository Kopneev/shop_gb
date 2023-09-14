package org.shop.shop;

import org.shop.exceptions.ProductDbEx;

import java.util.ArrayList;
import java.util.List;

public class ProductDb {
    private final List<Product> stock;

    public List<Product> getStock() {
        return stock;
    }

    public ProductDb() {
        this.stock = new ArrayList<>();
        this.stock.add(new Product("Товар 1", 22, 6.25));
        this.stock.add(new Product("Товар 2", 33, 2.33));
        this.stock.add(new Product("Товар 3", 76, 99.88));
        this.stock.add(new Product("Товар 4", 3, 22.33));
        this.stock.add(new Product("Товар 5", 25, 55.66));
    }

    public Product getProduct(int productId) throws ProductDbEx {
        // Подразумевается обращение к базе данных или хранилищу товаров
        // и получение информации о товаре по его ID
        // В данном примере мы используем заглушку
        if ((productId > 0) && (productId <= stock.size())) {
            return stock.get(productId - 1);
        }
        throw new ProductDbEx("Товар не найден.");
    }

    public void reduceProductQuantity(Product product, int quantity) {
        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
    }

}
