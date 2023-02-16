package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.model.request.Request;
import com.senla.server.model.request.RequestType;

public class InfoOperation implements Operational {
    public Request execute(String activeCardNumber, ConsoleManager consoleManager) {
        return new Request(RequestType.INFO, activeCardNumber);
    }
}
