public class Driver {
    public static void main(String[] args) {

        TextDocument document = new TextDocument();

        document.addCharacter('H', "Arial", "Red", 12);
        document.addCharacter('e', "Arial", "Red", 12);
        document.addCharacter('l', "Calibri", "Blue", 14);
        document.addCharacter('l', "Calibri", "Blue", 14);
        document.addCharacter('o', "Verdana", "Black", 16);
        document.addCharacter('W', "Arial", "Red", 12);
        document.addCharacter('o', "Verdana", "Black", 16);
        document.addCharacter('r', "Calibri", "Blue", 14);
        document.addCharacter('l', "Verdana", "Black", 16);
        document.addCharacter('d', "Arial", "Red", 12);

        document.saveToFile("document.txt");

        TextDocument loadedDocument = new TextDocument();
        loadedDocument.loadFromFile("document.txt");
        
        System.out.println(loadedDocument);
    }
}
