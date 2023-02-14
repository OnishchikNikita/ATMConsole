package com.senla.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readString() throws IOException {
        return reader.readLine();
    }

    public long readLong() throws IOException, NumberFormatException {
        return Long.parseLong(reader.readLine());
    }

    public byte readByte() throws IOException, NumberFormatException {
        return Byte.parseByte(reader.readLine());
    }
}
