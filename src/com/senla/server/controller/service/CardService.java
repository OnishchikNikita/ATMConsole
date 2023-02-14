package com.senla.server.controller.service;

import com.senla.server.controller.dao.CardDao;

public class CardService {
    public void block(String number) {
        new CardDao().getCard(number).setAvailable(false);
    }

    public boolean isAvailable(String number) {
        return new CardDao().getCard(number).isAvailable();
    }

    public long getInfo(String cardNumber) {
        return new CardDao().getCard(cardNumber).getBalance();
    }

    public boolean isValidNumber(String cardNumber) {
        return new CardDao().getCardMap().containsKey(cardNumber);
    }

    public boolean isValidPin(String cardNumber, String pin) {
        return new CardDao().getCardMap().get(cardNumber).getPin().equals(pin);
    }
}
