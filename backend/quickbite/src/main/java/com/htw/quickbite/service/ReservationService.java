package com.htw.quickbite.service;

import com.htw.quickbite.model.Reservation;
import com.htw.quickbite.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createAvailableRes(Reservation reservation){
        reservationRepository.save(reservation);

    }

    public Reservation getResByTableNr(int tableNr){

       return reservationRepository.findAll().stream().filter(a-> a.getTableNr() == tableNr).findFirst().orElse(null);
    }
    public List<Reservation>  getAvailableRes(){
        return reservationRepository.findAll().stream().filter(a-> a.isAvailable() == true).toList();
    }
    public List<Reservation> getAllRes(){
        return reservationRepository.findAll();
    }
}
