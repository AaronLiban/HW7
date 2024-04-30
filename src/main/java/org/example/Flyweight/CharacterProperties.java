package org.example.Flyweight;

public class CharacterProperties implements CharacterPropertiesInterface{
    private String font;
    private String color;
    private int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public String getFont() {
        return font;
    }

    @Override
    public void setFont(String font) {
        this.font = font;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "CharacterProperties{" +
                "font='" + font + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
