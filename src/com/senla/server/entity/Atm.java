package com.senla.server.entity;

public class Atm {
    private Long balance;

    public Atm(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
