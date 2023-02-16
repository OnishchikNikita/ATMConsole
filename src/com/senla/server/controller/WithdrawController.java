package com.senla.server.controller;

import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.model.request.Request;
import com.senla.server.model.request.WithdrawRequest;
import com.senla.server.model.response.Response;
import com.senla.server.service.WithdrawService;

public class WithdrawController implements IController {
    public Response execute(Request request) {
        WithdrawRequest withdrawRequest = (WithdrawRequest) request;
        try {
            new WithdrawService().perform(request.getCardNumber(), withdrawRequest.getAmount());
            return new Response("Your balance successfully changed.");
        } catch (NotEnoughBalanceException exception) {
            return new Response(exception.getMessage());
        }
    }
}
