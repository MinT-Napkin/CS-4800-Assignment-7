import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextDocument {
    private final List<Character> characters;
    private CharacterPropertiesFactory characterPropertiesFactory;

    public TextDocument()
    {
        characters = new ArrayList<>();
        characterPropertiesFactory = new CharacterPropertiesFactory();
    }

    public void addCharacter(char value, String font, String color, int size) {
        CharacterProperties character = characterPropertiesFactory.getCharacterProperties(font, color, size);
        characters.add(new Character(value, character));
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write(character.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String value = parts[0];
                    String font = parts[1];
                    String color = parts[2];
                    int size = Integer.parseInt(parts[3]);

                    CharacterProperties charProp = characterPropertiesFactory.getCharacterProperties(font, color, size);
                    characters.add(new Character(value.charAt(0), charProp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFactorySize() {
        characterPropertiesFactory.printCharacterPropertiesMapSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character.toString()).append("\n");
        }
        return sb.toString();
    }
}
