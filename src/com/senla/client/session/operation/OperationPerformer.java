package com.senla.client.session.operation;

import com.senla.client.console.ConsoleManager;
import com.senla.server.controller.request.Request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OperationPerformer {
    private final Map<OperationType, IOperation> operationMap = new HashMap<>();

    public OperationPerformer() {
        operationMap.put(OperationType.INFO, new InfoOperation());
        operationMap.put(OperationType.DEPOSIT, new DepositOperation());
        operationMap.put(OperationType.WITHDRAW, new WithdrawOperation());
    }

    public Request getRequest(OperationType operationType, String activeCardNumber, ConsoleManager consoleManager)
            throws IOException {
        return operationMap.get(operationType).perform(activeCardNumber, consoleManager);
    }
}
