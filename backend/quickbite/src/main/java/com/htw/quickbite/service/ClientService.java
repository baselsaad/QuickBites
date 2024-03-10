package com.htw.quickbite.service;

import com.htw.quickbite.model.Client;
import com.htw.quickbite.model.Reservation;
import com.htw.quickbite.repository.ClientRepository;
import com.htw.quickbite.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ReservationRepository reservationRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository, ReservationRepository reservationRepository){

            this.clientRepository = clientRepository;
            this.reservationRepository = reservationRepository;
    }

    public void createClient(Client client){

        clientRepository.save(client);
    }

    public String getClientUsernameById(String id){

        return clientRepository.findById(id).toString();
    }

    public Client getClientByUsername(String username){
      return   clientRepository.findAll().stream().filter(a -> a.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public void bookTable(Reservation reservation){
       reservationRepository.save(reservation);
    }


}
