public class CheckSparseVector {

    public static void main(String[] args) {
        testConstructorAndLength();
        testSetAndGetElement();
        testEqualsMethod();
        testAddMethod();
        testErrorHandling();
        testInvalidLengthConstructor();
    }

    // Test 1: Konstruktor und Längenprüfung
    private static void testConstructorAndLength() {
        System.out.println("Test 1: Standard-Konstruktor");
        SparseVector vector1 = new SparseVector(5);
        System.out.println("Länge des Vektors: " + vector1.getLength()); // Erwartet: 5
    }

    // Test 2: setElement und getElement
    private static void testSetAndGetElement() {
        System.out.println("\nTest 2: setElement und getElement");
        SparseVector vector1 = new SparseVector(5);
        vector1.setElement(2, 4.5);
        System.out.println("Element an Index 2: " + vector1.getElement(2)); // Erwartet: 4.5
        vector1.setElement(2, 0); // Entfernen des Elements
        System.out.println("Element an Index 2 nach Entfernen: " + vector1.getElement(2)); // Erwartet: 0.0
    }

    // Test 3: equals-Methode
    private static void testEqualsMethod() {
        System.out.println("\nTest 3: equals-Methode");
        SparseVector vector1 = new SparseVector(5);
        SparseVector vector2 = new SparseVector(5);
        vector1.setElement(1, 2.0);
        vector2.setElement(1, 2.0);
        System.out.println("Sind vector1 und vector2 gleich? " + vector1.equals(vector2)); // Erwartet: true
        vector2.setElement(3, 3.0);
        System.out.println("Sind vector1 und vector2 gleich nach Änderung? " + vector1.equals(vector2)); // Erwartet: false
    }

    // Test 4: add-Methode
    private static void testAddMethod() {
        System.out.println("\nTest 4: add-Methode");
        SparseVector vector1 = new SparseVector(5);
        vector1.setElement(1, 2.0);
        SparseVector vector3 = new SparseVector(5);
        vector3.setElement(1, 1.5);
        vector3.setElement(2, 2.5);
        vector1.add(vector3); // vector1 sollte jetzt {1: 3.5, 2: 2.5} sein
        System.out.println("Element an Index 1 nach Addition: " + vector1.getElement(1)); // Erwartet: 3.5
        System.out.println("Element an Index 2 nach Addition: " + vector1.getElement(2)); // Erwartet: 2.5
    }

    // Test 5: Fehlerbehandlung
    private static void testErrorHandling() {
        System.out.println("\nTest 5: Fehlerbehandlung");
        SparseVector vector1 = new SparseVector(5);
        try {
            vector1.setElement(10, 3.0); // Ungültiger Index
        } catch (Exception e) {
            System.out.println("Fehler beim Setzen: " + e.getMessage());
        }
        try {
            System.out.println("Element an ungültigem Index: " + vector1.getElement(10)); // Ungültiger Index
        } catch (Exception e) {
            System.out.println("Fehler beim Abrufen: " + e.getMessage());
        }
    }

    // Test 6: Konstruktor mit negativer Länge
    private static void testInvalidLengthConstructor() {
        System.out.println("\nTest 6: Konstruktor mit negativer Länge");
        SparseVector vectorInvalid = new SparseVector(-5); // Erwartet: Fehlermeldung
    }
}
