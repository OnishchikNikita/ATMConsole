package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.CardService;

public class BlockController {
    public Response execute(Request request) {
        new CardService().block(request.getCardNumber());
        return new Response("Your card was blocked.");
    }
}
