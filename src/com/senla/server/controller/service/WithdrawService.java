package com.senla.server.controller.service;

import com.senla.server.controller.request.WithdrawRequest;
import com.senla.server.controller.dao.ATMDao;
import com.senla.server.controller.dao.CardDao;
import com.senla.server.controller.entity.ATM;
import com.senla.server.controller.entity.Card;
import com.senla.server.controller.exception.NotEnoughBalanceException;
import com.senla.server.controller.response.Response;

public class WithdrawService {
    public Response perform(WithdrawRequest request) throws NotEnoughBalanceException {
        Card card = new CardDao().getCard(request.getCardNumber());
        ATM atm = new ATMDao().getATM();
        if (card.getBalance() < request.getAmount())
            throw new NotEnoughBalanceException("Not enough card balance!");
        else if (atm.getBalance() < request.getAmount())
            throw new NotEnoughBalanceException("Not enough atm balance!");
        else {
            card.setBalance(card.getBalance() - request.getAmount());
            atm.setBalance(atm.getBalance() - request.getAmount());
        }
        return new Response();
    }
}
