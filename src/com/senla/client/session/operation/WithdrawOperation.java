package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.exception.IllegalAmountException;
import com.senla.server.model.request.RequestType;
import com.senla.server.model.request.WithdrawRequest;

import java.io.IOException;

public class WithdrawOperation extends TransactionOperation {
    public WithdrawRequest execute(String cardNumber, ConsoleManager consoleManager)
            throws IOException, IllegalAmountException {
        return WithdrawRequest.toWithdrawRequest(super.execute(RequestType.WITHDRAW, cardNumber, consoleManager));
    }
}
