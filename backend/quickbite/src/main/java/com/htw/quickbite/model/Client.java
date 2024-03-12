package com.htw.quickbite.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String clientEmail;
    @Column
    private String username;
    @Column
    private String userPassword;
    @OneToOne(mappedBy = "client")
    private Reservation reservation;

    public Client(String clientEmail, String username, String userPassword) {
        this.clientEmail = clientEmail;
        this.username = username;
        this.userPassword = userPassword;
    }

    public Client() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;

    }


}
