package com.senla.server.service;

import com.senla.server.dao.CardDao;

import java.io.IOException;

public class CardService {
    public void block(String number) throws IOException {
        new CardDao().getCard(number).setAvailable(false);
        new DatabaseService().update();
    }

    public long getInfo(String cardNumber) {
        return new CardDao().getCard(cardNumber).getBalance();
    }
}
