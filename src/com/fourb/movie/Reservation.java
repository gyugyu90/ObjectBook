package com.fourb.movie;

public class Reservation {

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money calculatedFee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = calculatedFee;
        this.audienceCount = audienceCount;
    }
}
