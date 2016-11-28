public abstract class AbstractLinkedList implements Collectible {
    Node head;
    Node tail;
    int n;

    public AbstractLinkedList() {
      head = null;
      tail = null;
      n = 0;
    }
    
    public AbstractLinkedList(String[] elements) {
        for (String s : elements) {
            if (s != null) {
                // take advantage of your own add() method
                // to make this constructor
                add(s);
            }
        }
    }

    public void add(String s) {
        Node newNode = new Node(null, s);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        n++;
    }



    class Node {
        Node next;
        String value;

        public Node(Node next, String value) {
            this.next = next;
            this.value = value;
        }
    }

}
