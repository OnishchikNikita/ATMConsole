package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.exception.IllegalAmountException;
import com.senla.server.model.request.RequestType;
import com.senla.server.model.request.TransactionRequest;

import java.io.IOException;

public abstract class TransactionOperation implements Operational {
    public TransactionRequest execute(RequestType type, String cardNumber, ConsoleManager consoleManager)
            throws IOException, IllegalAmountException {
        consoleManager.getPrinter().printMessage("Enter amount.");
        long amount = consoleManager.getReader().readAmount();
        return new TransactionRequest(type, cardNumber, amount);
    }
}
