package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.CardService;

public class InfoController {
    public Response execute(Request request) {
        long balance = new CardService().getInfo(request.getCardNumber());
        return new Response("Your card balance is " + balance + "$");
    }
}
