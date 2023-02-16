package com.senla.server.dao;

import com.senla.server.entity.Atm;
import com.senla.server.database.Database;

public class AtmDao {
    public Atm getAtm() {
        return Database.getInstance().getAtm();
    }
}
