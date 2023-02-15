package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.controller.request.RequestType;
import com.senla.server.controller.request.TransactionRequest;

import java.io.IOException;

public class DepositOperation extends TransactionOperation {
    public TransactionRequest execute(String cardNumber, ConsoleManager consoleManager)
            throws IOException, NumberFormatException {
        return super.execute(RequestType.DEPOSIT, cardNumber, consoleManager);
    }
}
