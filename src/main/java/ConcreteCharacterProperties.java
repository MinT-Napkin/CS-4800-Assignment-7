public class ConcreteCharacterProperties {
    private final String font;
    private final String color;
    private final int size;

    public ConcreteCharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}