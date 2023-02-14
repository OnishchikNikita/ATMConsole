package com.senla.server.controller.controllers;

import com.senla.client.session.exception.IllegalAmountException;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.DepositService;

public class DepositController implements IController {
    public Response process(Request request) {
        try {
            new DepositService().deposit(request.getCardNumber(), request.getAmount());
            return new Response(true);
        } catch (IllegalAmountException exception) {
            return new Response(true);
        }
    }
}
