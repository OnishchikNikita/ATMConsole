package com.senla.server.controller;

import com.senla.server.model.request.Request;
import com.senla.server.model.response.Response;

import java.io.IOException;

public interface IController {
    Response execute(Request request) throws IOException;
}
