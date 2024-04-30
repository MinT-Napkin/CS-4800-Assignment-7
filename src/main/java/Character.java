public class Character {

    private char value;
    private CharacterProperties charProp;

    public Character(char value, CharacterProperties charProp)
    {
        this.value = value;
        this.charProp = charProp;
    }

    public Character(char value, String font, String color, int size)
    {
        this.value = value;
        this.charProp = new ConcreteCharacterProperties(font, color, size);
    }

    @Override
    public String toString() {
        return value + "," + charProp.getFont() + "," + charProp.getColor() + "," + charProp.getSize();
    }
}
