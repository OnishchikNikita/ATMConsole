package com.senla.server.service;

import com.senla.server.database.Database;
import com.senla.server.database.FileSystem;

import java.io.IOException;

public class DatabaseService {
    public void update() throws IOException {
        new FileSystem().updateFile(Database.getInstance().getContent());
        Database.getInstance().setContent(new FileSystem().getFileContent());
    }
}
