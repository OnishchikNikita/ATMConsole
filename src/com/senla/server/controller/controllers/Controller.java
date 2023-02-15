package com.senla.server.controller.controllers;

import com.senla.exception.InvalidNumberException;
import com.senla.exception.InvalidPinException;
import com.senla.exception.NotAvailableCardException;
import com.senla.exception.NotEnoughBalanceException;
import com.senla.server.controller.controllers.authorization.AuthorizationController;
import com.senla.server.controller.controllers.transaction.TransactionController;
import com.senla.server.controller.request.AuthorizationRequest;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.TransactionRequest;
import com.senla.server.controller.response.Response;


public class Controller {
    private final TransactionController transactionController = new TransactionController();
    private final AuthorizationController authorizationController = new AuthorizationController();

    public void authorization(AuthorizationRequest request)
            throws InvalidNumberException, NotAvailableCardException, InvalidPinException {
        authorizationController.execute(request);
    }

    public Response transaction(TransactionRequest request) throws NotEnoughBalanceException {
        return transactionController.execute(request);
    }

    public Response blockCard(Request request) {
        return new BlockController().execute(request);
    }

    public Response info(Request request) {
        return new InfoController().execute(request);
    }
}
