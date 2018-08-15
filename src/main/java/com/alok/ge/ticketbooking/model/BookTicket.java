package com.alok.ge.ticketbooking.model;

public class BookTicket {
    private String movieName;
    private String[] seatNumber;

    public BookTicket(String movieName, String[] seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
    }

    public BookTicket() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String[] getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String[] seatNumber) {
        this.seatNumber = seatNumber;
    }
}
