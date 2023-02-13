package com.senla.server.controller.service;

import com.senla.server.controller.request.DepositRequest;
import com.senla.server.controller.dao.ATMDao;
import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.entity.ATM;
import com.senla.server.controller.entity.Card;
import com.senla.server.controller.response.Response;

public class DepositService {
    public Response perform(DepositRequest request) {
        Card card = new CardDao().getCard(request.getCardNumber());
        ATM atm = new ATMDao().getATM();
        card.setBalance(card.getBalance() + request.getAmount());
        atm.setBalance(atm.getBalance() + request.getAmount());
        return new Response();
    }
}
