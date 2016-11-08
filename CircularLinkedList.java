import java.util.NoSuchElementException;

public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {

    public CircularLinkedList() {
        super();
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        if (first == null) {
            return true;
        } else {
            return false;
        }
    } 

    public int size() {
        return n;
    }

    public void add(String s) {
        Node newFirst = new Node(first, s);
        first = newFirst;
        n++;
    }

    public void remove(String s) {
        Node current = first;
        Node previous = null;

        if (first.value.equals(s)) {
            first = first.next;
            n--;
            return;
        }

        while (current != null) {
            if (current.value.equals(s)) {
                previous = current.next;
                n--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public String first() {
        return first.value;
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
        private Node current;
        private Node previous;
        
        public CircularLinkedListIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next;
            return node.value;
        }

        public void remove(String s) {
            previous.next = current.next;
            current = current.next;
            n--;
        }

        public String removeKthElement(int k) {
            int count = 0;
            String temp = "";

            while (count != k) {
                previous = current;
                current = current.next;
                count++;
            }

            if (count == k) {
                temp = current.value;
                previous.next = current.next;
                count = 0;
            }
            n--;
            return temp;
        }

        public boolean oneElementLeft() {
            if (current.next == null) {
                return true;
            } else {
                return false;
            }
        }
    }
}