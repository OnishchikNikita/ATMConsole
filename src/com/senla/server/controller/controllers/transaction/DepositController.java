package com.senla.server.controller.controllers.transaction;

import com.senla.exception.IllegalAmountException;
import com.senla.server.controller.request.TransactionRequest;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.DepositService;

public class DepositController implements Transactional {
    public Response execute(TransactionRequest request) {
        try {
            new DepositService().deposit(request.getCardNumber(), request.getAmount());
            return new Response("Your balance successfully changed.");
        } catch (IllegalAmountException exception) {
            return new Response(exception.getMessage());
        }
    }
}
