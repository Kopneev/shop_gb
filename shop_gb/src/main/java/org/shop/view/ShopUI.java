package org.shop.view;

import java.util.List;
import java.util.Scanner;

import org.shop.exceptions.ProductDbEx;
import org.shop.exceptions.ManagerEx;
import org.shop.shop.Product;
import org.shop.shop.Manager;

public class ShopUI {
    private final Scanner scanner = new Scanner(System.in);
    private final Manager manager;

    public ShopUI(Manager manager) {
        this.manager = manager;
    }

    public void run() {
        System.out.println("Добро пожаловать в магазин");
        availableCommand();
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> listProduct();
                case "2" -> buyProduct();
                case "0" -> {
                    return;
                }
                default -> availableCommand();
            }
        }
    }

    private void buyProduct() {
        int productId = getInt("Код товара ID");
        int quantity = getInt("Количество");
        try {
            double sum = manager.purchaseProduct(productId, quantity);
            System.out.println("Стоимость: $" + sum);
        } catch (ProductDbEx | ManagerEx e) {
            System.out.println(e.getMessage());
        }
    }

    private int getInt(String name) {
        System.out.print("Укажите " + name + ": ");
        String input = scanner.nextLine();
        while (!input.matches("[\\d]{1,9}")) {
            System.out.print(name + " must be numeric and positive, enter " + name + ": ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private void availableCommand() {
        System.out.println("""
                1 - список продуктов
                2 - выберите продукт для покупки
                0 - выход""");
    }

    private void listProduct() {
        List<Product> products = manager.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println("ID: " + (i + 1) + ",  " + products.get(i));
        }
    }
}