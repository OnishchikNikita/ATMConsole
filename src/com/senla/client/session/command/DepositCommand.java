package com.senla.client.session.command;

import com.senla.server.controller.request.DepositRequest;
import com.senla.server.controller.request.RequestType;
import com.senla.client.console.ConsoleReader;
import com.senla.client.console.ConsoleView;

import java.io.IOException;

public class DepositCommand implements ICommand {
    @Override
    public void perform(String activeCardNumber, ConsoleView consoleView) {
        consoleView.printAmountRequest();
        consoleView.printDepositRange();
        try {
            long amount = ConsoleReader.readLong();
            return new DepositRequest(RequestType.DEPOSIT, activeCardNumber, amount);
        } catch (NumberFormatException exception) {
            consoleView.printExceptionMessage(exception);
        } catch (IOException exception) {}
        return null;
    }


}
