package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;
import com.senla.server.controller.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final Map<RequestType, IController> controllerMap = new HashMap<>();
    private Response response;

    public Controller() {
        controllerMap.put(RequestType.VALIDATE_NUMBER, new ValidateNumberController());
        controllerMap.put(RequestType.VALIDATE_PIN, new ValidatePinController());
        controllerMap.put(RequestType.CARD_STATUS, new CardStatusController());
        controllerMap.put(RequestType.BLOCK_CARD, new BlockCardController());
        controllerMap.put(RequestType.INFO, new InfoController());
        controllerMap.put(RequestType.DEPOSIT, new DepositController());
        controllerMap.put(RequestType.WITHDRAW, new WithdrawController());
    }

    public void perform(Request request) {
        response = controllerMap.get(request.getType()).process(request);
    }

    public Response getResponse() {
        return response;
    }
}
