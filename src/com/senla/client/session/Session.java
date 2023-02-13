package com.senla.client.session;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;
import com.senla.client.session.command.CommandPerformer;
import com.senla.client.console.ConsoleReader;
import com.senla.server.controller.controllers.Controller;
import com.senla.client.console.ConsoleView;
import com.senla.server.controller.exception.IllegalCommandArgumentException;
import com.senla.server.controller.exception.NotAvailableCardException;

import java.io.IOException;

public class Session {
    public void run() {
        ConsoleView consoleView = new ConsoleView();
        Controller controller = new Controller();
        try {
            Authorization authorization = new Authorization();
            String activeCardNumber = authorization.perform(controller, consoleView);
            CommandPerformer commandPerformer = new CommandPerformer();
            boolean isEnough = false;
            while(!isEnough) {
                try {
                    byte commandOrdinal = ConsoleReader.readByte();
                    Request request = null;
                    switch (commandOrdinal) {
                        case 1 -> request = commandPerformer.perform(RequestType.INFO, activeCardNumber, consoleView);
                        case 2 -> request = commandPerformer.perform(RequestType.DEPOSIT, activeCardNumber, consoleView);
                        case 3 -> request = commandPerformer.perform(RequestType.WITHDRAW, activeCardNumber, consoleView);
                        case 4 -> isEnough = true;
                        default -> throw new IllegalCommandArgumentException("Illegal command argument.");
                    }
                    controller.processRequest(request);
                } catch (IllegalCommandArgumentException exception) {}
            }
        } catch (IOException exception) {
        } catch (NotAvailableCardException exception) {}

    }
}
