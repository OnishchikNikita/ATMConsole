package com.senla.server.controller;

import com.senla.exception.InvalidNumberException;
import com.senla.exception.InvalidPinException;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.model.request.AuthorizationRequest;
import com.senla.server.model.request.Request;
import com.senla.server.model.response.AuthorizationResponse;
import com.senla.server.service.AuthorizationService;

public class AuthorizationController implements IController {
    public AuthorizationResponse execute(Request request) {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) request;
        try {
            new AuthorizationService().execute(authorizationRequest.getCardNumber(), authorizationRequest.getPin());
            return new AuthorizationResponse("Successful authorization.", true);
        } catch (InvalidNumberException exception) {
            return new AuthorizationResponse(exception.getMessage(), false, "number");
        } catch (InvalidPinException exception) {
            return new AuthorizationResponse(exception.getMessage(), false, "pin");
        } catch (NotAvailableCardException exception) {
            return new AuthorizationResponse(exception.getMessage(), false, "status");
        }
    }
}
