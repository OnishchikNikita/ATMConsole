package com.senla.server.controller.entity;

public class Card {
    private final String number;
    private final String pin;
    private boolean isAvailable;
    private Long balance;

    public Card(String number, String pin, boolean availableStatus, Long balance) {
        this.number = number;
        this.pin = pin;
        this.isAvailable = availableStatus;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
