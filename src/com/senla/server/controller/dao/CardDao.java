package com.senla.server.controller.dao;

import com.senla.server.controller.entity.Card;
import com.senla.server.database.Data;

import java.util.Map;

public class CardDao {
    public Card getCard(String number) {
        return new Data().getCardMap().get(number);
    }

    public Map<String, Card> getCardMap() {
        return new Data().getCardMap();
    }
}
