import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextDocumentTest {

    @Test
    public void testAddCharacter() {
        TextDocument document = new TextDocument();
        document.addCharacter('H', "Arial", "Red", 12);
        assertEquals(1, document.getCharacters().size());
    }

    @Test
    public void testSaveAndLoadFromFile() throws IOException {
        TextDocument document = new TextDocument();
        document.addCharacter('H', "Arial", "Red", 12);
        document.addCharacter('e', "Arial", "Red", 12);
        document.addCharacter('l', "Arial", "Red", 12);
        document.addCharacter('l', "Arial", "Red", 12);
        document.addCharacter('o', "Arial", "Red", 12);

        String filename = "testDocument.txt";
        document.saveToFile(filename);

        TextDocument loadedDocument = new TextDocument();
        loadedDocument.loadFromFile(filename);

        assertEquals(document.getCharacters().size(), loadedDocument.getCharacters().size());
        for (int i = 0; i < document.getCharacters().size(); i++) {
            assertEquals(document.getCharacters().get(i).getValue(), loadedDocument.getCharacters().get(i).getValue());
            assertEquals(document.getCharacters().get(i).getCharProp().getFont(), loadedDocument.getCharacters().get(i).getCharProp().getFont());
            assertEquals(document.getCharacters().get(i).getCharProp().getColor(), loadedDocument.getCharacters().get(i).getCharProp().getColor());
            assertEquals(document.getCharacters().get(i).getCharProp().getSize(), loadedDocument.getCharacters().get(i).getCharProp().getSize());
        }

        // Clean up the test file
        File file = new File(filename);
        assertTrue(file.delete());
    }
}
