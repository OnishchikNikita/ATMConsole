package com.senla.server.controller.service;

import com.senla.server.controller.dao.AtmDao;
import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.entity.Atm;
import com.senla.server.controller.entity.Card;
import com.senla.client.session.exception.NotEnoughBalanceException;

public class WithdrawService {
    public void perform(String cardNumber, Long amount) throws NotEnoughBalanceException {
        Card card = new CardDao().getCard(cardNumber);
        Atm atm = new AtmDao().getAtm();
        if (card.getBalance() < amount)
            throw new NotEnoughBalanceException("Not enough card balance!");
        else if (atm.getBalance() < amount)
            throw new NotEnoughBalanceException("Not enough atm balance!");
        else {
            card.setBalance(card.getBalance() - amount);
            atm.setBalance(atm.getBalance() - amount);
        }
    }
}
