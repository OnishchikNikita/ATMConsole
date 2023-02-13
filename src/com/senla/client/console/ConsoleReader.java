package com.senla.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static long readLong() throws IOException, NumberFormatException {
        return Long.parseLong(reader.readLine());
    }

    public static byte readByte() throws IOException, NumberFormatException {
        return Byte.parseByte(reader.readLine());
    }
}
