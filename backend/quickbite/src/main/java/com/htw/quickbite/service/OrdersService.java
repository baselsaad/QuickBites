package com.htw.quickbite.service;

import com.htw.quickbite.model.Order;
import com.htw.quickbite.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private OrdersRepository orderRepository;
@Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.orderRepository = ordersRepository;
    }


    public void createOrder(Order orders){
    orderRepository.save(orders);
    }

    public void deleteOrders(String orderId){
        orderRepository.deleteById(orderId);
    }

    public Order getOrderById(String id){
    return orderRepository.findAll().stream().filter(a-> a.getOrderId().equals(id)).findFirst().orElse(null);
    }

    public List<Order> getAllOrders(){
    return orderRepository.findAll();

    }

}
