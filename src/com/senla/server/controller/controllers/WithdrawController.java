package com.senla.server.controller.controllers;

import com.senla.client.session.exception.NotEnoughBalanceException;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.WithdrawService;

public class WithdrawController implements IController {
    public Response process(Request request) {
        try {
            new WithdrawService().perform(request.getCardNumber(), request.getAmount());
            return new Response(true);
        } catch (NotEnoughBalanceException exception) {
            return new Response(true);
        }
    }
}
