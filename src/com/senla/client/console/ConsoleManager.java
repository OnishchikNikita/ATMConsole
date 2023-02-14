package com.senla.client.console;

public class ConsoleManager {
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsolePrinter printer = new ConsolePrinter();

    public ConsoleReader getReader() {
        return reader;
    }

    public ConsolePrinter getPrinter() {
        return printer;
    }
}

