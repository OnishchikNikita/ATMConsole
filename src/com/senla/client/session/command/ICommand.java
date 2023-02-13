package com.senla.client.session.command;

import com.senla.server.controller.request.Request;
import com.senla.client.console.ConsoleView;

import java.io.IOException;

public interface ICommand {
    Request perform(String activeCardNumber, ConsoleView consoleView) throws IOException;
}
