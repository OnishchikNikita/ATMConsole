package com.senla.server.controller.service;

import com.senla.server.controller.request.InfoRequest;
import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.response.Response;

public class InfoService {
    public Response getInfo(InfoRequest request) {
        return new CardDao().getCard(request.getCardNumber()).getBalance();
        return new Response();
    }
}
