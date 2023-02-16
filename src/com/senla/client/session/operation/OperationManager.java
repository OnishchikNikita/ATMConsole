package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.model.request.Request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OperationManager {
    private final Map<Operation, Operational> operationalMap = new HashMap<>();

    public OperationManager() {
        operationalMap.put(Operation.INFO, new InfoOperation());
        operationalMap.put(Operation.DEPOSIT, new DepositOperation());
        operationalMap.put(Operation.WITHDRAW, new WithdrawOperation());
        operationalMap.put(Operation.EXIT, new InfoOperation());
    }

    public Request execute(Operation operation, String cardNumber, ConsoleManager consoleManager) throws IOException {
        return operationalMap.get(operation).execute(cardNumber, consoleManager);
    }
}
