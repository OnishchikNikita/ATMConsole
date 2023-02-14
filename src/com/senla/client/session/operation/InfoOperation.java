package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;

public class InfoOperation implements IOperation {
    @Override
    public Request perform(String activeCardNumber, ConsoleManager consoleManager) {
        return new Request(RequestType.INFO, activeCardNumber);
    }
}
