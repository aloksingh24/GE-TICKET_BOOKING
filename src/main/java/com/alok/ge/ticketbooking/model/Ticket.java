package com.alok.ge.ticketbooking.model;

import javax.persistence.*;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private long id;

    @Column(name = "ticket_seat_no")
    private int seatNumber;

    @ManyToOne()
    private Movie movie;

    public Ticket() {
    }

    public Ticket(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

}
