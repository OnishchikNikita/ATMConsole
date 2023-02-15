package com.senla.server.controller.service;

import com.senla.server.controller.dao.CardDao;

public class CardService {
    public void block(String number) {
        new CardDao().getCard(number).setAvailable(false);
    }

    public long getInfo(String cardNumber) {
        return new CardDao().getCard(cardNumber).getBalance();
    }
}
