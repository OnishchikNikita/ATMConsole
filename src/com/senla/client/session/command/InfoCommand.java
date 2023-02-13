package com.senla.client.session.command;

import com.senla.server.controller.request.InfoRequest;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;
import com.senla.client.console.ConsoleView;

public class InfoCommand implements ICommand {
    @Override
    public Request perform(String activeCardNumber, ConsoleView consoleView) {
        return new InfoRequest(RequestType.INFO, activeCardNumber);
    }
}
