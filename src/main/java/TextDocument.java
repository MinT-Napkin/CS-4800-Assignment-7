import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Document class representing a document containing characters with shared properties
public class TextDocument {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char value, String font, String color, int size) {
        ConcreteCharacterProperties properties = CharacterPropertiesFactory.getCharacterProperties(font, color, size);
        characters.add(new Character(value, properties));
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
                    char value = parts[0].charAt(0);
                    String font = parts[1];
                    String color = parts[2];
                    int size = Integer.parseInt(parts[3]);
                    addCharacter(value, font, color, size);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
