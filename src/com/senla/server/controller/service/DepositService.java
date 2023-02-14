package com.senla.server.controller.service;

import com.senla.server.controller.dao.AtmDao;
import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.entity.Atm;
import com.senla.server.controller.entity.Card;
import com.senla.client.session.exception.IllegalAmountException;

public class DepositService {
    public void deposit(String cardNumber, Long amount) throws IllegalAmountException {
        Card card = new CardDao().getCard(cardNumber);
        Atm atm = new AtmDao().getAtm();
        card.setBalance(card.getBalance() + amount);
        atm.setBalance(atm.getBalance() + amount);
    }
}
