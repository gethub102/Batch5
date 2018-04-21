package com.wenbin.datastructure;

import java.util.*;

public class Menu {
    List<Product> menuList;

    public Menu(List<Product> menuList) {
        this.menuList = menuList;
    }

    public Menu() {
        menuList = new ArrayList<Product>();
    }

    public boolean addProduct(Product product) {
        this.menuList.add(product);
        return true;
    }

    public boolean addProductFromInput() {
        System.out.println("add a product? yes or no?");

        try (Scanner scanner = new Scanner(System.in)) {
            String decision = scanner.nextLine();
            System.out.println(decision);
            decision = decision.toLowerCase();
            if (decision.equals("yes") || decision.equals("y")) {
                System.out.print("product id => ");
                String id = scanner.nextLine().trim();

                System.out.print("product name => ");
                String name = scanner.nextLine().trim();

                System.out.print("product cat => ");
                String cat = scanner.nextLine().trim();

                System.out.print("product Price => ");
                double price = Double.parseDouble(scanner.nextLine().trim());
                this.menuList.add(new Product(id, name, cat, price));
            }
            else {
                return false;
            }

        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int find(Product product) {
        if (this.menuList == null || this.menuList.size() == 0) {
            return -1;
        }
        int index = 0;
        for (Product product1 : this.menuList) {
            if (product1.equals(product)) {
                return index++;
            }
        }
        return -1;
    }

    public boolean remove (Product product) {
        int index = this.find(product);
        if (index != -1) {
            this.menuList.remove(index);
            return true;
        }
        return false;
    }

    public void displayAll() {
        System.out.println(this.menuList.toString());
    }

    public void showRangeMenu(double minPrice, double maxPrice) {

        if (maxPrice  < minPrice) {
            double tmp = minPrice;
            minPrice = maxPrice;
            maxPrice = tmp;
        }

        for (Product product : this.menuList) {
            if (product.getPprice() >= minPrice && product.getPprice() <= maxPrice) {
                System.out.println(product + " ");
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
//        Product product1 = new Product("P_id", "P_name", "P_cat", 20);
//        Product product2 = new Product("R_id", "R_name", "R_cat", 22);
//        Product product3 = new Product("T_id", "T_name", "T_cat", 23);
//        Product product4 = new Product("Y_id", "Y_name", "Y_cat", 27);
//        Product product5 = new Product("U_id", "U_name", "U_cat", 10);
//        Product product6 = new Product("I_id", "I_name", "I_cat", 90);

        menu.addProductFromInput();
        menu.addProductFromInput();

        System.out.println("\n\n---- show the menu after Input added product -----");
        menu.displayAll();
//
//        menu.addProduct(product1);
//        menu.addProduct(product2);
//        menu.addProduct(product3);
//        menu.addProduct(product4);
//        menu.addProduct(product5);
//        menu.addProduct(product6);
//
//        System.out.println(" \n\n--- show the menu after added object of product --- ");
//        menu.displayAll();
//
//        System.out.println(" \n\n--- show the product with a range of price  --- ");
//        menu.showRangeMenu(20, 30);
//
//
//        System.out.println(" \n\n--- show remove a product from menu list  --- ");
//        boolean remove = menu.remove(new Product("P_id", "P_name", "P_cat", 20));
//        menu.displayAll();
//        if (remove) {
//            System.out.println("remove success");
//        }
    }

}
