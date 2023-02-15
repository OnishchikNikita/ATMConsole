package com.senla.client.session;

import com.senla.client.console.ConsoleManager;
import com.senla.client.session.operation.DepositOperation;
import com.senla.client.session.operation.InfoOperation;
import com.senla.client.session.operation.Operation;
import com.senla.client.session.operation.WithdrawOperation;
import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.controller.controllers.Controller;
import com.senla.exception.IllegalOperationArgumentException;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.controller.request.TransactionRequest;
import com.senla.server.controller.response.Response;

import java.io.IOException;

public class Session {
    public void run(Controller controller, ConsoleManager consoleManager) {
        try {
            Authorization authorization = new Authorization();
            String cardNumber = authorization.run(controller, consoleManager);
            Operation operation = null;
            do {
                try {
                    consoleManager.getPrinter().printMessage("Select operation\n1.Info. 2.Deposit. 3.Withdraw. 4.Exit.");
                    byte ordinal = consoleManager.getReader().readByte();
                    operation = Operation.getOperationByOrdinal(ordinal);
                    switch (operation) {
                        case INFO: {
                            Response response = controller.info(new InfoOperation().execute(cardNumber));
                            consoleManager.getPrinter().printMessage(response.message());
                        }
                        case DEPOSIT: {
                            TransactionRequest request = new DepositOperation().execute(cardNumber, consoleManager);
                            Response response = controller.transaction(request);
                            consoleManager.getPrinter().printMessage(response.message());
                        }
                        case WITHDRAW: {
                            TransactionRequest request = new WithdrawOperation().execute(cardNumber, consoleManager);
                            Response response = controller.transaction(request);
                            consoleManager.getPrinter().printMessage(response.message());
                        }
                    }
                } catch (IllegalOperationArgumentException | NumberFormatException | NotEnoughBalanceException exception) {
                    consoleManager.getPrinter().printMessage(exception.getMessage());
                }
            } while (operation != Operation.EXIT);
        } catch (IOException | NotAvailableCardException exception) {
            consoleManager.getPrinter().printMessage(exception.getMessage());
        }
    }
}
