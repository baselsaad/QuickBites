package com.htw.quickbite.model;

import jakarta.persistence.*;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;
    @Column
    private int tableNr;
    @Column
    private boolean available;
    @Column
    private String date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    public Reservation(String bookingId, int tableNr, boolean available, String date, Client client) {
        this.bookingId = bookingId;
        this.tableNr = tableNr;
        this.available = available;
        this.date = date;
        this.client = client;
    }

    public Reservation() {

    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getTableNr() {
        return tableNr;
    }

    public void setTableNr(int tableNr) {
        this.tableNr = tableNr;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
