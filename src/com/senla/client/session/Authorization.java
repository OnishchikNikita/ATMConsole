package com.senla.client.session;

import com.senla.client.console.ConsoleManager;
import com.senla.server.model.request.*;
import com.senla.server.controller.Controller;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.model.response.AuthorizationResponse;
import com.senla.server.model.response.Response;

import java.io.IOException;

public class Authorization {
    public String run(Controller controller, ConsoleManager consoleManager)
            throws IOException, NotAvailableCardException {
        String number = null;
        byte attempts = 3;
        while (attempts > 0) {
            consoleManager.getPrinter().printMessage("Enter your card number.");
            number = consoleManager.getReader().readString();
            consoleManager.getPrinter().printMessage("Enter PIN.");
            String pin = consoleManager.getReader().readString();
            Response response = controller.execute(new AuthorizationRequest(RequestType.AUTHORIZATION, number, pin));
            AuthorizationResponse authorizationResponse = (AuthorizationResponse) response;
            if (!authorizationResponse.isSuccess()) {
                switch (authorizationResponse.getCause()) {
                    case "pin" -> attempts--;
                    case "status" -> throw new NotAvailableCardException(authorizationResponse.getMessage());
                }
                consoleManager.getPrinter().printMessage(authorizationResponse.getMessage());
            } else {
                consoleManager.getPrinter().printMessage(authorizationResponse.getMessage());
                return number;
            }
        }
        controller.execute(new BlockCardRequest(RequestType.BLOCK_CARD, number));
        throw new NotAvailableCardException("Your card is blocked!");
    }
}




