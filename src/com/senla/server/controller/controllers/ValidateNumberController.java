package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.CardService;

public class ValidateNumberController implements IController {
    @Override
    public Response process(Request request) {
        boolean exist = new CardService().isValidNumber(request.getCardNumber());
        return new Response(true);
    }
}
