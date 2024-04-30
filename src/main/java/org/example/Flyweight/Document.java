package org.example.Flyweight;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Document {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(char value, CharacterProperties properties) {
        characters.add(new Character(value, properties));
    }

    public void createDocument(String text, CharacterProperties properties) {
        for(char value : text.toCharArray()) {
            addCharacter(value, properties);
        }
    }

    public void editDocument(CharacterProperties properties) {
        for(Character value : characters) {
            value.setProperties(properties);
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try {
            FileWriter writer = new FileWriter(fileName);
            for(Character value : characters) {
                writer.write(value.getValue());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error has occured.");
        }
    }

    public void loadFromFile(String fileName, CharacterProperties properties) {
        try {
            File document = new File(fileName);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(document),
                            Charset.forName("UTF-8")));
            int r;
            while ((r = reader.read()) != -1) {
                char value = (char) r;
                addCharacter(value, properties);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Character> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return "Document{" +
                "characters=" + characters +
                '}';
    }
}
