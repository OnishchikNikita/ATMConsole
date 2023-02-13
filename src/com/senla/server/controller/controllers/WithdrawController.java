package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;
import com.senla.server.controller.service.WithdrawService;

public class WithdrawController implements IController {
    public Response process(Request request) {
        return new WithdrawService().perform(request);
    }
}
