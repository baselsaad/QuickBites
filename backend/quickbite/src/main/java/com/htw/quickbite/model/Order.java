package com.htw.quickbite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table
@Entity(name = "order-table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    @Column
    private String orderName;

    @Column
    private int price;

    @ManyToOne()
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public Order(String orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
