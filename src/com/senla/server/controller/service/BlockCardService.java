package com.senla.server.controller.service;

import com.senla.server.controller.request.CardBlockRequest;
import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.response.Response;

public class BlockCardService {
    public Response block(CardBlockRequest request) {
        new CardDao().getCard(request.getCardNumber()).setAvailable(false);
        return new Response();
    }
}
