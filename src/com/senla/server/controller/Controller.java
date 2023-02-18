package com.senla.server.controller;

import com.senla.server.model.request.Request;
import com.senla.server.model.request.RequestType;
import com.senla.server.model.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final Map<RequestType, IController> controllerMap = new HashMap<>();

    public Controller() {
        controllerMap.put(RequestType.AUTHORIZATION, new AuthorizationController());
        controllerMap.put(RequestType.INFO, new InfoController());
        controllerMap.put(RequestType.DEPOSIT, new DepositController());
        controllerMap.put(RequestType.WITHDRAW, new WithdrawController());
        controllerMap.put(RequestType.BLOCK_CARD, new BlockCardController());
    }

    public Response execute(Request request) throws IOException {
        return controllerMap.get(request.getType()).execute(request);
    }
}
