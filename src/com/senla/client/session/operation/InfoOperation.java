package com.senla.client.session.operation;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.request.RequestType;

public class InfoOperation {
    public Request execute(String activeCardNumber) {
        return new Request(RequestType.INFO, activeCardNumber);
    }
}
