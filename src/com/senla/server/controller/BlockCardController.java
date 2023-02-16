package com.senla.server.controller;

import com.senla.server.model.request.BlockCardRequest;
import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;
import com.senla.server.service.CardService;

public class BlockCardController implements IController {
    public Response execute(Request request) {
        BlockCardRequest blockCardRequest = (BlockCardRequest) request;
        new CardService().block(blockCardRequest.getCardNumber());
        return new Response("Your card was blocked.");
    }
}
