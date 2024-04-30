package org.example.Flyweight;
import java.util.HashMap;
public class CharacterFactory {
    private HashMap<String, CharacterProperties> characterProperties = new HashMap<>();

    public CharacterProperties getCharacter(String font, String color, int size) {
        String key = font + color + size;
        if(characterProperties.containsKey(key)) {
            return characterProperties.get(key);
        } else {
            CharacterProperties characterProperty = new CharacterProperties(font, color, size);
            characterProperties.put(key, characterProperty);
            return characterProperty;
        }
    }
}
