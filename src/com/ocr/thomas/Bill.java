package com.ocr.thomas;

import java.util.HashMap;
import java.util.Map;

public class Bill {
    private Customer customer;
    private Map<Product, Integer> products = new HashMap<Product, Integer>();
    private Delivery delivery;

    public Bill(Customer customer, Delivery delivery) {
        this.customer = customer;
        this.delivery = delivery;
    }

    public void addProduct(Product product, Integer quantity){
        this.products.put(product, quantity);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void generate(Writer writer) {
        if (products.isEmpty())
            throw new NoProductInBillException();
        writer.start();
        writer.writerLine("HomeShop compagnie");
        writer.writerLine("1 Place Charles de Gaulle, 75008 Paris");
        writer.writerLine("");
        writer.writerLine("Facture à l'attention de :");
        writer.writerLine(customer.getFullname());
        writer.writerLine(customer.getAddress());
        writer.writerLine("");
        writer.writerLine("Mode de livraison : " + delivery.getInfo());
        writer.writerLine("");
        writer.writerLine("Produits :");
        writer.writerLine("------------------------------------------------");
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            writer.writerLine(product.getName() + " - " + product.getPrice() + " - " + quantity + " unité(s)");
            writer.writerLine(product.getDescription());
            writer.writerLine("");
        }
        writer.writerLine("Livraison : " + delivery.getPrice());
        writer.writerLine("-------------------------------------------------");
        writer.writerLine("Total :" + this.getTotal());
        writer.stop();
    }
    
    
    public double getTotal(){
        double total = delivery.getPrice();
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
}
