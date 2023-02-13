package com.senla.client.session;

import com.senla.server.controller.request.*;
import com.senla.server.controller.controllers.Controller;
import com.senla.server.controller.exception.NotAvailableCardException;
import com.senla.client.console.ConsoleReader;
import com.senla.client.console.ConsoleView;

import java.io.IOException;

public class Authorization {
    public String perform(Controller controller, ConsoleView consoleView) throws IOException, NotAvailableCardException {
        consoleView.printNumberRequest();
        String number = null;
        while () {
            number = ConsoleReader.readString();
            controller.processRequest(new CardExistRequest(RequestType.CARD_EXIST, number));
        }
        consoleView.printPinRequest();
        String pin;
        boolean isEnough = false;
        byte attempts = 3;
        do {
            if (attempts == 0) {
                controller.processRequest(new CardBlockRequest(RequestType.BLOCK_CARD, number));
                throw new NotAvailableCardException("Your card is blocked!");
            }
            pin = ConsoleReader.readString();
            controller.processRequest(new PinRequest(RequestType.PIN, number, pin));
            attempts--;
        } while (!isEnough);
        return number;
    }
}
