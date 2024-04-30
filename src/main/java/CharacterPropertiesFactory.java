import java.util.HashMap;

public class CharacterPropertiesFactory {
    private HashMap<String, CharacterProperties> characterMap = new HashMap<>();

    public CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = getKey(font, color, size);
        if (characterMap.containsKey(key)) {
            return characterMap.get(key);
        } else {
            CharacterProperties character = new ConcreteCharacterProperties(font, color, size);
            characterMap.put(key, character);
            return character;
        }
    }

    public void printCharacterPropertiesMapSize()
    {
        int size = characterMap.size();
        System.out.println(size);
    }

    private String getKey(String font, String color, int size) {
        return font + "_" + color + "_" + size;
    }
}