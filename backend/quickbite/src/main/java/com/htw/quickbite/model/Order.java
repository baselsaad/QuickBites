package com.htw.quickbite.model;

import jakarta.persistence.*;

@Table
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
 private String orderId;
    @Column
 private String orderName;

    public Order(String orderId, String orders) {
        this.orderId = orderId;
        this.orderName = orders;
    }

    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrders() {
        return orderName;
    }

    public void setOrders(String orders) {
        this.orderName = orders;
    }
}
