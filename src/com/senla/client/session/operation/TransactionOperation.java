package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.controller.request.RequestType;
import com.senla.server.controller.request.TransactionRequest;

import java.io.IOException;

public abstract class TransactionOperation {
    public TransactionRequest execute(RequestType type, String cardNumber, ConsoleManager consoleManager)
            throws IOException, NumberFormatException {
        consoleManager.getPrinter().printMessage("Enter amount.");
        long amount = consoleManager.getReader().readLong();
        return new TransactionRequest(type, cardNumber, amount);
    }
}
