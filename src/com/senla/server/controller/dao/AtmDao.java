package com.senla.server.controller.dao;

import com.senla.server.controller.entity.Atm;
import com.senla.server.database.Database;

public class AtmDao {
    public Atm getAtm() {
        return Database.getInstance().getAtm();
    }
}
