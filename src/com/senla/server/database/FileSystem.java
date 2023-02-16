package com.senla.server.database;

import com.senla.server.entity.Atm;
import com.senla.server.entity.Card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private final Path path = Path.of("src\\com\\senla\\server\\database\\File");

    public FileContent getFileContent() throws IOException {
        String stringContent = new String(Files.readAllBytes(path));
        String[] arrayContent = stringContent.split(" ");
        ArrayDeque<String> dequeContent = new ArrayDeque<>();
        for (String element : arrayContent) {
            dequeContent.addLast(element);
        }
        Atm atm = new Atm(Long.parseLong(dequeContent.pop()));
        Map<String, Card> cardMap = new HashMap<>();
        while (!dequeContent.isEmpty()) {
            String number = dequeContent.pop();
            String pin = dequeContent.pop();
            boolean available = dequeContent.pop().equals("available");
            Long balance = Long.parseLong(dequeContent.pop());
            Card card = new Card(number, pin, available, balance);
            cardMap.put(card.getNumber(), card);
        }
        return new FileContent(cardMap, atm);
    }

    public void updateFile(FileContent content) throws IOException {
        StringBuilder stringContent = new StringBuilder();
        stringContent.append(content.atm().getBalance());
        for (Map.Entry<String, Card> card : content.cardMap().entrySet()) {
            stringContent.append(" ").append(card.getValue().getNumber());
            stringContent.append(" ").append(card.getValue().getPin());
            stringContent.append(" ").append(card.getValue().isAvailable() ? "available" : "block");
            stringContent.append(" ").append(card.getValue().getBalance());
        }
        File file = new File(path.toUri());
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(stringContent.toString());
        fileWriter.close();
    }
}
