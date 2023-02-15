package com.senla.server.controller.controllers.transaction;

import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.controller.request.TransactionRequest;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.WithdrawService;

public class WithdrawController implements Transactional {
    public Response execute(TransactionRequest request) throws NotEnoughBalanceException {
        new WithdrawService().perform(request.getCardNumber(), request.getAmount());
        return new Response("Your balance successfully changed.");
    }
}
