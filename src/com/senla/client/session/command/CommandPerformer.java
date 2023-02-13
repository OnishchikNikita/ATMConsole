package com.senla.client.session.command;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;
import com.senla.client.console.ConsoleView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandPerformer {
    private final Map<RequestType, ICommand> commandMap = new HashMap<>();

    public CommandPerformer() {
        commandMap.put(RequestType.INFO, new InfoCommand());
        commandMap.put(RequestType.DEPOSIT, new DepositCommand());
        commandMap.put(RequestType.WITHDRAW, new WithdrawCommand());
    }

    public Request perform(RequestType requestType, String activeCardNumber, ConsoleView consoleView)
            throws IOException {
        return commandMap.get(requestType).perform(activeCardNumber, consoleView);
    }
}
