package com.senla.client.session;

import com.senla.client.console.ConsoleManager;
import com.senla.client.session.operation.*;
import com.senla.exception.IllegalAmountException;
import com.senla.server.controller.Controller;
import com.senla.exception.IllegalOperationArgumentException;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;

import java.io.IOException;

public class Session {
    public void run(Controller controller, ConsoleManager consoleManager) {
        try {
            OperationManager operationManager = new OperationManager();
            Authorization authorization = new Authorization();
            String cardNumber = authorization.run(controller, consoleManager);
            Operation operation = null;
            do {
                try {
                    consoleManager.getPrinter().printMessage("Menu\n1.Info 2.Deposit 3.Withdraw 4.Exit");
                    byte operationArgument = consoleManager.getReader().readOperationArgument();
                    operation = Operation.getOperationByOrdinal(operationArgument);
                    if (operation != Operation.EXIT) {
                        Request request = operationManager.execute(operation, cardNumber, consoleManager);
                        Response response = controller.execute(request);
                        consoleManager.getPrinter().printMessage(response.getMessage());
                    }
                } catch (IllegalOperationArgumentException | IllegalAmountException exception) {
                    consoleManager.getPrinter().printMessage(exception.getMessage());
                }
            } while (operation != Operation.EXIT);
        } catch (IOException | NotAvailableCardException exception) {
            consoleManager.getPrinter().printMessage(exception.getMessage());
        }
    }
}
