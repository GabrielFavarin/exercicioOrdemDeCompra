package entities;

import entities.enums.OrderStatus;

import java.text.Format;

public class OrderItem {

    private int quantity;
    private Double price;

    private Product product;

    private OrderItem(){
    }

    public OrderItem(int quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(int quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double subTotal(){
        return quantity*price;
    }

    @Override
    public String toString() {
        return product.getName() + ", " + String.format("$%.2f", price) + ", Quantity: " + quantity +
                ", Subtotal: " + String.format("$%.2f", subTotal());
    }
}
