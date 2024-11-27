// Java Klasse SparseVector
public class SparseVector {
	
	// Linked List
    private Node head;
    // Länge der Linked List
    private int length;

    // Hilfsklasse Node für die verkettete Liste
    private static class Node {
    	// Wert an Index x
        double value;
        // Index
        int index;
        //
        Node next;
        
        
        // Node Constructor
        Node(double value, int index) {
            this.value = value;
            this.index = index;
            // nächste Instanz wird 0 gesetzt
            this.next = null;
        }
    }

    // Standard-Konstruktor, der einen leeren Vektor initialisiert.
    public SparseVector() {
        this.head = null;
        this.length = 0;
    }

    // Konstruktor: erstellt einen Vektor der gegebenen Länge
    public SparseVector(int length) {
        if (length < 0) throw new IllegalArgumentException("Länge muss positiv sein.");
        this.head = null;
        this.length = length;
    }

    // Methode zum Setzen eines Elements
    public void setElement(int index, double value) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException("Ungültiger Index.");

        if (value == 0) {
            removeElement(index);
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null && current.index < index) {
            prev = current;
            current = current.next;
        }

        if (current != null && current.index == index) {
            current.value = value;
        } else {
            Node newNode = new Node(value, index);
            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current;
                prev.next = newNode;
            }
        }
    }

    // Methode zum Abrufen eines Elements
    public double getElement(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException("Ungültiger Index.");

        Node current = head;
        while (current != null) {
            if (current.index == index) {
                return current.value;
            }
            current = current.next;
        }
        return 0.0; // Standardwert für nicht vorhandene Elemente
    }

    // Methode zum Entfernen eines Elements
    public void removeElement(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException("Ungültiger Index.");

        Node prev = null;
        Node current = head;

        while (current != null && current.index != index) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    // Methode zur Abfrage der Länge
    public int getLength() {
        return length;
    }

    // Methode zum Vergleich mit einem anderen SparseVector
    public boolean equals(SparseVector other) {
    	
        if (this.length != other.length) {
        	return false;
        }

        Node current1 = this.head;
        Node current2 = other.head;

        while (current1 != null && current2 != null) {
            if (current1.index != current2.index || current1.value != current2.value) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }

    // Methode zum Addieren eines anderen SparseVectors
    public void add(SparseVector other) {
        if (other == null || this.length != other.length) throw new IllegalArgumentException("SparseVectors müssen die gleiche Länge haben.");

        Node current = other.head;
        while (current != null) {
            this.setElement(current.index, this.getElement(current.index) + current.value);
            current = current.next;
        }
    }

}
