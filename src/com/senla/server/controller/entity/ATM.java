package com.senla.server.controller.entity;

public class ATM {
    private Long balance;

    public ATM(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
