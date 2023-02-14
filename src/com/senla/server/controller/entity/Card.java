package com.senla.server.controller.entity;

public class Card {
    private final String number;
    private final String pin;
    private boolean available;
    private Long balance;

    public Card(String number, String pin, boolean available, Long balance) {
        this.number = number;
        this.pin = pin;
        this.available = available;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
