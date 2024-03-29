package com.htw.quickbite.controller;

import com.htw.quickbite.model.Client;
import com.htw.quickbite.model.Order;
import com.htw.quickbite.model.Reservation;
import com.htw.quickbite.repository.OrdersRepository;
import com.htw.quickbite.service.CartService;
import com.htw.quickbite.service.ClientService;
import com.htw.quickbite.service.OrdersService;
import com.htw.quickbite.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class ClientController {

    private ClientService clientService;
    private ReservationService reservationService;
    private OrdersService ordersService;
    private CartService cartService;
   @Autowired
    public ClientController(ClientService clientService, ReservationService reservationService, OrdersService ordersService, CartService cartService) {
        this.clientService = clientService;
        this.reservationService = reservationService;
        this.ordersService = ordersService;
        this.cartService = cartService;
    }

    @PostMapping(value = "/signin")
    public void createClient(@RequestBody Client client){
       clientService.createClient(client);
    }
    @GetMapping(value = "/users/{username}")
    public Client getClientByUsername(@PathVariable String username){

       return clientService.getClientByUsername(username);

    }
    @GetMapping(value = "/users")
    public List<Client> getAllClients(){
       return clientService.getAllClients();
    }
    @PutMapping(value = "/book/{username}/{resID}")
    public void bookTable(@PathVariable String resID, @PathVariable String username){
       clientService.bookTable(resID,username);
    }
    @PostMapping(value = "create/reservation")
    public Reservation createReservation(@RequestBody Reservation reservation){
     return  reservationService.createAvailableRes(reservation);

    }
    @GetMapping(value = "/reservations")
    public List<Reservation> getAllReservations(){
       return reservationService.getAllRes();
    }
    @PostMapping(value = "order/create")
    public void createOrder(@RequestBody Order order){
       ordersService.createOrder(order);
    }
    @DeleteMapping(value = "/order/delete/{orderId}")
    public void deleteOrder(String orderId){
       ordersService.deleteOrders(orderId);
    }
    @GetMapping("/order/{id}")
    public Order getOrderById(String id){
      return ordersService.getOrderById(id);
    }
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
       return ordersService.getAllOrders();
    }
    @PostMapping(value = "/add/cart")
    public void addOrderToCart(@RequestBody Order order){
       cartService.addOrderToCart(order);
    }

    @DeleteMapping(value = "/delete/cart/order-id/{id}")
    public void deleteOrderFromCart(String id){
        cartService.deleteOrderFromCart(id);
    }


}
