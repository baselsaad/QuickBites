package com.htw.quickbite.service;

import com.htw.quickbite.model.Cart;
import com.htw.quickbite.model.Order;
import com.htw.quickbite.repository.CartRepository;
import com.htw.quickbite.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private Cart cart;
    private CartRepository cartRepository;
    private OrdersRepository ordersRepository;
   @Autowired
    public CartService(CartRepository cartRepository,OrdersRepository ordersRepository) {
        this.cartRepository = cartRepository;
        this.ordersRepository = ordersRepository;
    }

    public Cart createCart(){
       if(cart == null){
           cart = new Cart();
           cartRepository.save(cart);
       }
       return cart;
    }

    public void addOrderToCart(Order order){
       Cart cart = createCart();
       cart.addOrderToCart(order);
       cartRepository.save(cart);
       ordersRepository.save(order);

    }
    public void deleteOrderFromCart(String id){
        Cart cart = createCart();
        cart.deleteOrderFromCart(id);
        ordersRepository.deleteById(id);
        cartRepository.save(cart);
    }
}
