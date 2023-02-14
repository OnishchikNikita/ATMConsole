package com.senla.client.session;

import com.senla.client.console.ConsoleManager;
import com.senla.client.session.exception.InvalidNumberException;
import com.senla.server.controller.request.*;
import com.senla.server.controller.controllers.Controller;
import com.senla.client.session.exception.NotAvailableCardException;

import java.io.IOException;

public class Authorization {
    public String run(Controller controller, ConsoleManager consoleManager)
            throws IOException, NotAvailableCardException {
        do {
            try {
                consoleManager.getPrinter().printMessage("Enter your card number.");
                String number = consoleManager.getReader().readString();
                controller.perform(new Request(RequestType.VALIDATE_NUMBER, number));
                if(!controller.getResponse().isSuccess()) throw new InvalidNumberException("Invalid card number!");
                controller.perform(new Request(RequestType.CARD_STATUS, number));
                if(!controller.getResponse().isSuccess()) throw new NotAvailableCardException("Your card is blocked!");
                consoleManager.getPrinter().printMessage("Enter PIN.");
                byte attempts = 3;
                while (attempts > 0) {
                    String pin = consoleManager.getReader().readString();
                    controller.perform(new Request(RequestType.VALIDATE_PIN, number, pin));
                    if (controller.getResponse().isSuccess()) return number;
                    attempts--;
                }
                controller.perform(new Request(RequestType.BLOCK_CARD, number));
                throw new NotAvailableCardException("Your card is blocked!");
            } catch (InvalidNumberException exception) {
                consoleManager.getPrinter().printMessage(exception.getMessage());
            }
        } while(true);
    }
    /*public String runn(Controller controller, ConsoleManager consoleManager)
            throws IOException, NotAvailableCardException {
        String number = new NumberValidation().run(controller, consoleManager);
        Response response = controller.getResponse(new Request(RequestType.CARD_STATUS, number));
        if(!response.isSuccess()) throw new NotAvailableCardException("Your card is blocked!");
        new PinValidation().run(controller, consoleManager, number);
        return number;
    }*/
}

/*class NumberValidation {
    public String run(Controller controller, ConsoleManager consoleManager)
            throws IOException {
        do {
            try {
                consoleManager.getPrinter().printMessage("Enter your card number.");
                String number = consoleManager.getReader().readString();
                Response response = controller.getResponse(new Request(RequestType.VALIDATE_NUMBER, number));
                if(response.isSuccess()) return number;
                else throw new InvalidNumberException("Invalid card number!");
            } catch (InvalidNumberException exception) {
                consoleManager.getPrinter().printMessage(exception.getMessage());
            }
        } while(true);
    }
}

class PinValidation {
    public void run(Controller controller, ConsoleManager consoleManager, String number)
            throws IOException, NotAvailableCardException {
        consoleManager.getPrinter().printMessage("Enter PIN.");
        byte attempts = 3;
        do {
            if (attempts == 0) {
                controller.getResponse(new Request(RequestType.BLOCK_CARD, number));
                throw new NotAvailableCardException("Your card is blocked!");
            }
            String pin = consoleManager.getReader().readString();
            Response response = controller.getResponse(new Request(RequestType.VALIDATE_PIN, number, pin));
            if(response.isSuccess()) break;
            attempts--;
        } while (true);
    }
}*/
