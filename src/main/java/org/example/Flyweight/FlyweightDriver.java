package org.example.Flyweight;

import javax.print.Doc;
import java.io.IOException;

public class FlyweightDriver {
    public static void main(String[] args) throws IOException {
        Document doc1 = new Document();
        String text = "HelloWorldCS5800";
        CharacterProperties properties1 = new CharacterProperties("Arial", "Red", 12);

        doc1.createDocument(text, properties1);
        System.out.println("Doc1 :" + doc1);
        doc1.saveToFile("doc1");

        Document doc2 = new Document();
        CharacterProperties properties2 = new CharacterProperties("Calibri", "Blue", 14);

        doc2.loadFromFile("doc1", properties2);
        System.out.println("Doc2 :" + doc2);
        doc2.saveToFile("doc2");

        Document doc3 = new Document();
        CharacterProperties properties3 = new CharacterProperties("Verdana", "Black", 16);

        doc3.loadFromFile("doc1", properties3);
        System.out.println("Doc3 :" + doc3);
        doc3.saveToFile("doc3");

        Document doc4 = new Document();
        CharacterProperties properties4 = new CharacterProperties("Arial", "Blue", 16);

        doc4.loadFromFile("doc1", properties3);
        doc4.editDocument(properties4);
        System.out.println("Doc4 :" + doc4);
        doc4.saveToFile("doc4");
    }
}
