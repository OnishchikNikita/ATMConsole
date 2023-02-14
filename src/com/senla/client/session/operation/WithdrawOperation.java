package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;

import java.io.IOException;

public class WithdrawOperation implements IOperation {
    public Request perform(String activeCardNumber, ConsoleManager consoleManager) throws IOException {
        consoleManager.getPrinter().printMessage("Enter amount.");
        try {
            long amount = consoleManager.getReader().readLong();
            return new Request(RequestType.WITHDRAW, activeCardNumber, amount);
        } catch (NumberFormatException exception) {
            consoleManager.getPrinter().printMessage(exception.getMessage());
        }
        return null;
    }
}
