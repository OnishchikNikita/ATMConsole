package com.senla.server.controller.service;

import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.entity.Card;
import com.senla.server.controller.response.Response;

import java.util.Map;

public class CardExistService {
    public Response find() {
        Map<String, Card> cardMap = new CardDao().getCardMap();
        return new Response();
    }
}
