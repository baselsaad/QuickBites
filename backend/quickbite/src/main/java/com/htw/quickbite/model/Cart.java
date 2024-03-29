package com.htw.quickbite.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Table
@Entity

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cartId;
    @OneToMany(mappedBy = "cart")
    private List<Order> orders;

    public Cart(String cartId, List<Order> orders) {
        this.cartId = cartId;
        this.orders = orders;
    }

    public Cart() {
       orders = new ArrayList<>();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void addOrderToCart(Order order){
        order.setCart(this);
        this.orders.add(order);
    }
    public void deleteOrderFromCart(String orderId){
     Order  order = orders.stream().filter(a-> a.getOrderId().equals(orderId)).findFirst().orElse(null);
     orders.remove(order);
    }
}
