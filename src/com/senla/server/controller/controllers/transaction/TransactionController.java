package com.senla.server.controller.controllers.transaction;

import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.controller.request.RequestType;
import com.senla.server.controller.request.TransactionRequest;
import com.senla.server.controller.response.Response;

import java.util.HashMap;
import java.util.Map;

public class TransactionController {
    private final Map<RequestType, Transactional> transactionControllerMap = new HashMap<>();

    public TransactionController() {
        transactionControllerMap.put(RequestType.DEPOSIT, new DepositController());
        transactionControllerMap.put(RequestType.WITHDRAW, new WithdrawController());
    }

    public Response execute(TransactionRequest request) throws NotEnoughBalanceException {
        return transactionControllerMap.get(request.getType()).execute(request);
    }
}
