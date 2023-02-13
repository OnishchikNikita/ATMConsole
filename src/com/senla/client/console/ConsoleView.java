package com.senla.client.console;

public class ConsoleView {
    public void printResponse() {

    }
    public void printNumberRequest() {
        System.out.println("Enter your card number.");
    }

    public void printPinRequest() {
        System.out.println("Enter PIN.");
    }

    public void printAmountRequest() {
        System.out.println("Enter amount.");
    }

    public void printDepositRange() { System.out.println("No more than 1,000,000."); }

    public void printExceptionMessage(Exception exception) {
        System.err.println(exception.getMessage());
    }
}
