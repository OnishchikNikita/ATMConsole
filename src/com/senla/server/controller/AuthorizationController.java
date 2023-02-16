package com.senla.server.controller;

import com.senla.exception.InvalidNumberException;
import com.senla.exception.InvalidPinException;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.model.request.AuthorizationRequest;
import com.senla.server.model.response.Response;
import com.senla.server.service.AuthorizationService;

public class AuthorizationController {
    public Response execute(AuthorizationRequest request)
            throws InvalidNumberException, NotAvailableCardException, InvalidPinException {
        new AuthorizationService().run(request.getCardNumber(), request.getPin());
        return new Response("Successful authorization.");
    }
}
