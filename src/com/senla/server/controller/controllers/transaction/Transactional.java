package com.senla.server.controller.controllers.transaction;

import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.controller.request.TransactionRequest;
import com.senla.server.controller.response.Response;

public interface Transactional {
    Response execute(TransactionRequest request) throws NotEnoughBalanceException;
}
