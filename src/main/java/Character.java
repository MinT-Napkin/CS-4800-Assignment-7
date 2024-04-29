public class Character {
    private final char value;
    private final ConcreteCharacterProperties properties;

    public Character(char value, ConcreteCharacterProperties properties) {
        this.value = value;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return value + "," + properties.getFont() + "," + properties.getColor() + "," + properties.getSize();
    }
}
