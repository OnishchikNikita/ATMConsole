package com.senla.server.controller.controllers;

import com.senla.client.session.command.DepositCommand;
import com.senla.client.session.command.InfoCommand;
import com.senla.client.session.command.WithdrawCommand;
import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;
import com.senla.server.controller.response.Response;

import java.util.Map;

public class Controller {
    private Map<RequestType, IController> controllerMap;

    public Controller() {
        controllerMap.put(RequestType.DEPOSIT, new DepositController());
        controllerMap.put(RequestType.WITHDRAW, new WithdrawCommand());
    }

    public Response processRequest(Request request) {
        controllerMap.get(request.getType()).process(request);
    }
}
