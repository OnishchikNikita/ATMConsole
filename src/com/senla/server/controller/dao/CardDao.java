package com.senla.server.controller.dao;

import com.senla.server.controller.entity.Card;
import com.senla.server.database.Database;

import java.util.Map;

public class CardDao {
    public Card getCard(String number) {
        return Database.getInstance().getCardMap().get(number);
    }

    public Map<String, Card> getCardMap() {
        return Database.getInstance().getCardMap();
    }
}
