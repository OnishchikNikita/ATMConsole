package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.CardService;

public class BlockCardController implements IController {
    @Override
    public Response process(Request request) {
        new CardService().block(request.getCardNumber());
        return new Response(true);
    }
}
