package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.CardService;

public class ValidatePinController implements IController {
    @Override
    public Response process(Request request) {
        boolean valid = new CardService().isValidPin(request.getCardNumber(), request.getPin());
        return new Response(true);
    }
}
