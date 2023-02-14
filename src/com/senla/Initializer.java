package com.senla;

import com.senla.client.console.ConsoleManager;
import com.senla.client.session.Session;
import com.senla.server.controller.controllers.Controller;
import com.senla.server.database.Database;
import com.senla.server.database.FileSystem;

import java.io.IOException;

public class Initializer {
    public void initialize() {
        try {
            Database.getInstance().setContent(new FileSystem().getFileContent());
            Controller controller = new Controller();
            ConsoleManager consoleManager = new ConsoleManager();
            Session session = new Session();
            session.run(controller, consoleManager);
        } catch (IOException exception) {}
    }
}
