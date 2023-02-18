package com.senla.client.console;

import com.senla.exception.IllegalAmountException;
import com.senla.exception.IllegalOperationArgumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readString() throws IOException {
        return reader.readLine();
    }

    public long readAmount() throws IOException, IllegalAmountException {
        try {
            return Long.parseLong(reader.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalAmountException("Illegal amount.");
        }
    }

    public byte readOperationArgument() throws IOException, IllegalOperationArgumentException {
        try {
            return Byte.parseByte(reader.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalOperationArgumentException("Illegal operation argument.");
        }
    }
}
