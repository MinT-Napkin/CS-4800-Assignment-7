import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {

    @Test
    void testGetCharacterProperties() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();

        CharacterProperties properties1 = factory.getCharacterProperties("Arial", "Red", 12);
        assertNotNull(properties1);
        assertEquals("Arial", properties1.getFont());
        assertEquals("Red", properties1.getColor());
        assertEquals(12, properties1.getSize());

        CharacterProperties properties2 = factory.getCharacterProperties("Arial", "Red", 12);
        assertSame(properties1, properties2);

        CharacterProperties properties3 = factory.getCharacterProperties("Calibri", "Blue", 14);
        assertNotSame(properties1, properties3);
    }

    @Test
    void testPrintCharacterPropertiesMapSize() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();

        assertEquals(0, factory.getCharacterMap().size());
        factory.getCharacterProperties("Arial", "Red", 12);
        assertEquals(1, factory.getCharacterMap().size());
        factory.getCharacterProperties("Arial", "Red", 12); // Repeated call
        assertEquals(1, factory.getCharacterMap().size());
        factory.getCharacterProperties("Calibri", "Blue", 14);
        assertEquals(2, factory.getCharacterMap().size());
    }
}