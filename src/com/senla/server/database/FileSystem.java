package com.senla.server.database;

import com.senla.server.controller.entity.Card;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Map;

public class FileSystem {
    private final Path path = Path.of("src\\com\\senla\\server\\database\\Data");


    public void uploadFile() throws IOException {
        String stringContent = new String(Files.readAllBytes(path));
        String[] arrayContent = stringContent.split(" ");
        ArrayDeque<String> dequeContent = new ArrayDeque<>();
        for (String element : arrayContent) {
            dequeContent.addLast(element);
        }
        atmBalance = new Balance(Long.parseLong(dequeContent.pop()));
        while (!dequeContent.isEmpty()) {
            String number = dequeContent.pop();
            String pin = dequeContent.pop();
            boolean isAvailable = dequeContent.pop().equals("available");
            Long balance = Long.parseLong(dequeContent.pop());
            Card card = new Card(number, pin, isAvailable, balance);
            cards.put(card.getNumber(), card);
        }
    }

    public void updateFile(Balance atmBalance, Map<String, Card> cards) throws IOException {
        StringBuilder stringContent = new StringBuilder();
        stringContent.append(atmBalance.getValue());
        for (Map.Entry<String, Card> card : cards.entrySet()) {
            stringContent.append(" ").append(card.getValue().toString());
        }
        java.io.File financeData = new java.io.File(path.toUri());
        FileWriter fileWriter = new FileWriter(financeData, false);
        fileWriter.write(stringContent.toString());
        fileWriter.close();
    }


}
