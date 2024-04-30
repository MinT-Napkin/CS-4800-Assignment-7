package Flyweight;

public class Driver {
    public static void main(String[] args) {

        TextDocument document = new TextDocument();

        document.addCharacter('H', "Arial", "Red", 12);
        document.addCharacter('e', "Calibri", "Blue", 14);
        document.addCharacter('l', "Verdana", "Black", 16);
        document.addCharacter('l', "Calibri", "Red", 1);
        document.addCharacter('o', "Verdana", "Black", 16);
        document.addCharacter('W', "Calibri", "Blue", 14);
        document.addCharacter('o', "Verdana", "Black", 16);
        document.addCharacter('r', "Arial", "Red", 12);
        document.addCharacter('l', "Verdana", "Black", 16);
        document.addCharacter('d', "Arial", "Red", 12);
        document.addCharacter('C', "Verdana", "Black", 16);
        document.addCharacter('S', "Arial", "Red", 12);
        document.addCharacter('5', "Verdana", "Black", 16);
        document.addCharacter('8', "Calibri", "Red", 1);
        document.addCharacter('0', "Verdana", "Black", 16);
        document.addCharacter('0', "Calibri", "Red", 1);

        System.out.println("Printing out created document: ");
        System.out.println(document);

        System.out.println("Save to file...\n");
        document.saveToFile("document.txt");
        TextDocument loadedDocument = new TextDocument();
        loadedDocument.loadFromFile("document.txt");


        System.out.println("Printing out loaded document: ");
        System.out.println(loadedDocument);

        System.out.println("Printing out character properties hash map size to showcase Flyweight design implementation working: ");
        loadedDocument.printFactorySize();
    }
}
