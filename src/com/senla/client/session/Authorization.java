package com.senla.client.session;

import com.senla.client.console.ConsoleManager;
import com.senla.exception.InvalidNumberException;
import com.senla.exception.InvalidPinException;
import com.senla.server.model.request.*;
import com.senla.server.controller.Controller;
import com.senla.exception.NotAvailableCardException;

import java.io.IOException;

public class Authorization {
    public String run(Controller controller, ConsoleManager consoleManager)
            throws IOException, NotAvailableCardException {
        byte attempts = 3;
        while (attempts > 0) {
            consoleManager.getPrinter().printMessage("Enter your card number.");
            String number = consoleManager.getReader().readString();
            consoleManager.getPrinter().printMessage("Enter PIN.");
            String pin = consoleManager.getReader().readString();
            try {
                controller.authorization(new AuthorizationRequest(RequestType.AUTHORIZATION, number, pin));
                return number;
            } catch (InvalidNumberException exception) {
                consoleManager.getPrinter().printMessage(exception.getMessage());
            } catch (InvalidPinException exception) {
                consoleManager.getPrinter().printMessage(exception.getMessage());
                attempts--;
                if (attempts == 0) {
                    controller.execute(new BlockCardRequest(RequestType.BLOCK_CARD, number));
                }
            }
        }
        throw new NotAvailableCardException("Your card is blocked!");
    }
}




