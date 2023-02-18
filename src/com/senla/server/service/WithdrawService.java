package com.senla.server.service;

import com.senla.exception.IllegalAmountException;
import com.senla.server.dao.AtmDao;
import com.senla.server.dao.CardDao;
import com.senla.server.entity.Atm;
import com.senla.server.entity.Card;
import com.senla.exception.NotEnoughBalanceException;

import java.io.IOException;

public class WithdrawService {
    public void execute(String cardNumber, Long amount)
            throws IOException, IllegalAmountException, NotEnoughBalanceException {
        Card card = new CardDao().getCard(cardNumber);
        Atm atm = new AtmDao().getAtm();
        if (amount <= 0) throw new IllegalAmountException("Illegal withdraw amount!");
        if (card.getBalance() < amount) throw new NotEnoughBalanceException("Not enough card balance!");
        if (atm.getBalance() < amount) throw new NotEnoughBalanceException("Not enough atm balance!");
        card.setBalance(card.getBalance() - amount);
        atm.setBalance(atm.getBalance() - amount);
        new DatabaseService().update();
    }
}
