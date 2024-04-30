import org.example.Flyweight.Character;
import org.example.Flyweight.CharacterProperties;
import org.example.Flyweight.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FlyweightTest {
    Document doc = new Document();
    CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);

    @Test
    public void testAddCharacter() {
        doc.addCharacter('a', properties);
        Character actual = doc.getCharacters().get(0);
        assertNotNull(actual);
    }

    @Test
    public void testCreateDocument() {
        doc.createDocument("Hi", properties);
        List<Character> actual = doc.getCharacters();
        assertNotNull(actual);
    }

    @Test
    public void testEditDocument() {
        doc.createDocument("Hi", properties);
        CharacterProperties expected = new CharacterProperties("Calibri", "Blue", 14);
        doc.editDocument(expected);
        CharacterProperties actual = doc.getCharacters().get(0).getProperties();
        assertEquals(expected, actual);
    }

    @Test
    public void testSaveToFileAndLoadFromFile() throws IOException {
        doc.createDocument("Hi", properties);
        List<Character> expected = doc.getCharacters();
        doc.saveToFile("test.txt");
        Document actual = new Document();
        actual.loadFromFile("test.txt", properties);
        assertEquals(expected.get(0).getValue(), actual.getCharacters().get(0).getValue());
    }
}
