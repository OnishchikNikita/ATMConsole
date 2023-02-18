package com.senla.server.controller;

import com.senla.server.model.request.InfoRequest;
import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;
import com.senla.server.service.CardService;

public class InfoController implements IController {
    public Response execute(Request request) {
        InfoRequest infoRequest = (InfoRequest) request;
        long info = new CardService().getInfo(infoRequest.getCardNumber());
        return new Response("Your balance: " + info + "$");
    }
}
