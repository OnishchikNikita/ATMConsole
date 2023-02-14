package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.controller.request.Request;

import java.io.IOException;

public interface IOperation {
    Request perform(String activeCardNumber, ConsoleManager consoleManager) throws IOException;
}
