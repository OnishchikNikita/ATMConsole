package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.CardService;

public class InfoController implements IController {
    @Override
    public Response process(Request request) {
        long info = new CardService().getInfo(request.getCardNumber());
        return new Response(true);
    }
}
