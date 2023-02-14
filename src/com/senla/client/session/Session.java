package com.senla.client.session;

import com.senla.client.console.ConsoleManager;
import com.senla.client.session.operation.OperationType;
import com.senla.server.controller.request.Request;
import com.senla.client.session.operation.OperationPerformer;
import com.senla.server.controller.controllers.Controller;
import com.senla.client.session.exception.IllegalOperationArgumentException;
import com.senla.client.session.exception.NotAvailableCardException;

import java.io.IOException;

public class Session {
    public void run(Controller controller, ConsoleManager consoleManager) {
        try {
            Authorization authorization = new Authorization();
            String activeCardNumber = authorization.run(controller, consoleManager);
            OperationPerformer operationPerformer = new OperationPerformer();
            OperationType operationType = null;
            do {
                try {
                    consoleManager.getPrinter().printMessage("" +
                            "Select operation\n1 - Show balance. 2 - Deposit. 3 - Withdraw. 4 - Exit." +
                            "");
                    byte ordinal = consoleManager.getReader().readByte();
                    operationType = OperationType.getOperationByOrdinal(ordinal);
                    controller.perform(operationPerformer.getRequest(operationType, activeCardNumber, consoleManager));
                } catch (IllegalOperationArgumentException exception) {
                    consoleManager.getPrinter().printMessage(exception.getMessage());
                }
            } while (operationType != OperationType.EXIT);
        } catch (IOException | NotAvailableCardException exception) {
            consoleManager.getPrinter().printMessage(exception.getMessage());
        }
    }
}
