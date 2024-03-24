package com.htw.quickbite.controller;

import com.htw.quickbite.model.Client;
import com.htw.quickbite.model.Reservation;
import com.htw.quickbite.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class ClientController {

    private ClientService clientService;
   @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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
    @PostMapping(value = "/book")
    public void bookTable(@RequestBody Reservation reservation){
       clientService.bookTable(reservation);
    }

}
