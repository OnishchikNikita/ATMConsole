package com.senla.server.controller;

import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;

public interface IController {
    Response execute(Request request);
}
