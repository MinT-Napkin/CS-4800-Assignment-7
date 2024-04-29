import java.util.HashMap;
import java.util.Map;

class CharacterPropertiesFactory {
    private static final Map<String, ConcreteCharacterProperties> flyweights = new HashMap<>();

    public static ConcreteCharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + color + size;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteCharacterProperties(font, color, size));
        }
        return flyweights.get(key);
    }
}