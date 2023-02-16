package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.model.request.RequestType;
import com.senla.server.model.request.TransactionRequest;

import java.io.IOException;

public class DepositOperation extends TransactionOperation implements Operational {
    public TransactionRequest execute(String cardNumber, ConsoleManager consoleManager)
            throws IOException, NumberFormatException {
        consoleManager.getPrinter().printMessage("No more than 1,000,000$.");
        return super.execute(RequestType.DEPOSIT, cardNumber, consoleManager);
    }
}
