package com.senla.server.controller.controllers;

import com.senla.server.controller.request.Request;
import com.senla.server.controller.response.Response;

public interface IController {
    Response process(Request request);
}
