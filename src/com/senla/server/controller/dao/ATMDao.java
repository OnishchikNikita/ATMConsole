package com.senla.server.controller.dao;

import com.senla.server.controller.entity.ATM;
import com.senla.server.database.Data;

public class ATMDao {
    public ATM getATM() {
        return new Data().getAtm();
    }
}
