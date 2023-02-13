package com.senla.server.database;

import com.senla.server.controller.entity.ATM;
import com.senla.server.controller.entity.Card;

import java.util.Map;

public class Data {
    private Map<String, Card> cardMap;
    private ATM atm;

    public Map<String, Card> getCardMap() {
        return cardMap;
    }

    public ATM getAtm() {
        return atm;
    }
}
