package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.exception.IllegalAmountException;
import com.senla.server.model.request.Request;

import java.io.IOException;

public interface Operational {
    Request execute(String cardNumber, ConsoleManager consoleManager) throws IOException, IllegalAmountException;
}
