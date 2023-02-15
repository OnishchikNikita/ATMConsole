package com.senla.server.controller.controllers.authorization;

import com.senla.exception.InvalidNumberException;
import com.senla.exception.InvalidPinException;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.controller.request.AuthorizationRequest;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.AuthorizationService;

public class AuthorizationController {
    public Response execute(AuthorizationRequest request)
            throws InvalidNumberException, NotAvailableCardException, InvalidPinException {
        new AuthorizationService().run(request.getCardNumber(), request.getPin());
        return new Response("Successful authorization.");
    }
}
