public class ConcreteCharacterProperties implements CharacterProperties {

    private String font;
    private String color;
    private int size;

    public ConcreteCharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }


    @Override
    public String getType() {
        return "Character";
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