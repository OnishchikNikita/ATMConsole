package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.exception.IllegalAmountException;
import com.senla.server.model.request.DepositRequest;
import com.senla.server.model.request.RequestType;

import java.io.IOException;

public class DepositOperation extends TransactionOperation {
    public DepositRequest execute(String cardNumber, ConsoleManager consoleManager)
            throws IOException, IllegalAmountException {
        consoleManager.getPrinter().printMessage("No more than 1,000,000$.");
        return DepositRequest.toDepositRequest(super.execute(RequestType.DEPOSIT, cardNumber, consoleManager));
    }
}
