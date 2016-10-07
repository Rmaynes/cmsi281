import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Bag implements Collectible {
    private Node first;
    private int n; // number of unique nodes
    private int total; // total number of words in this bag

    public Bag() {
        first = null;
    }

    public boolean isEmpty() {
        if (total == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return total;
    }

    public void add(String item) {
        boolean unique = true;
        total++;

        for (Obliterator i = iterator(); i.hasNext(); ) {
            Node nextUp = i.next();
            if (item.equals(nextUp.item) && checkEquals(item)) {
                nextUp.count++;
                unique = false;
            }
        }

        if (unique) {
            n++;
            Node nextUp = first;
            first = new Node(nextUp, item, 1);
        }
    }

    // Implement Collectible interface methods here

    public int uniqueSize() {
        return n;
    }

    public Obliterator iterator() {
        return new BagIterator(first);  
    }

    class BagIterator implements Obliterator {
        private Node current;

        public BagIterator(Node first) {
            current = first;
        }

        public boolean hasNext() { 
            return current != null;  
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next;
            return node;
        }
    }

    public boolean checkEquals(String item) {
        if (first.item.length() == item.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Bag bag = new Bag();
        Scanner s = null;
        int total = 0;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                bag.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        // Print bag size and distinct contents
        System.out.format("Total number of words: %d\n", bag.size());
        System.out.format("Unique number of words: %d\n", bag.uniqueSize());

        // Print distinct words in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
    }

}
