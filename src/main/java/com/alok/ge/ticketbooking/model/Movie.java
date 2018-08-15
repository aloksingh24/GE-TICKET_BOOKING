package com.alok.ge.ticketbooking.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "movie_seat")
    private int totalSeat;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Ticket> ticket;

    public Movie() {
    }

    public Movie(String name, int totalSeat) {
        this.name = name;
        this.totalSeat = totalSeat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }
}
