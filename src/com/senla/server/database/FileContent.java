package com.senla.server.database;

import com.senla.server.entity.Atm;
import com.senla.server.entity.Card;

import java.util.Map;

public record FileContent(Map<String, Card> cardMap, Atm atm) {
}
