package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.model.request.InfoRequest;
import com.senla.server.model.request.RequestType;

public class InfoOperation implements Operational {
    public InfoRequest execute(String activeCardNumber, ConsoleManager consoleManager) {
        return new InfoRequest(RequestType.INFO, activeCardNumber);
    }
}
