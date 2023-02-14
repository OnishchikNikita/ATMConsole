package com.senla.server.database;

import com.senla.server.controller.entity.Atm;
import com.senla.server.controller.entity.Card;

import java.util.Map;

public class Database {
    private static Database instance;
    private FileContent content;

    private Database() {}

    public static Database getInstance() {
        if (instance == null) instance = new Database();
        return instance;
    }

    public void setContent(FileContent content) {
        this.content = content;
    }

    public Map<String, Card> getCardMap() {
        return content.cardMap();
    }

    public Atm getAtm() {
        return content.atm();
    }
}
