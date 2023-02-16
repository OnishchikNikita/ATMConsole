package com.senla.server.service;

import com.senla.exception.InvalidNumberException;
import com.senla.exception.InvalidPinException;
import com.senla.exception.NotAvailableCardException;
import com.senla.server.dao.CardDao;
import com.senla.server.entity.Card;

public class AuthorizationService {
    public void run(String number, String pin)
            throws InvalidNumberException, NotAvailableCardException, InvalidPinException  {
        Card card;
        if (!new CardDao().getCardMap().containsKey(number)) throw new InvalidNumberException("Invalid card number!");
        else card = new CardDao().getCard(number);
        if (!card.isAvailable()) throw new NotAvailableCardException("Your card is blocked!");
        if (!card.getPin().equals(pin)) throw new InvalidPinException("Invalid PIN!");
    }
}
