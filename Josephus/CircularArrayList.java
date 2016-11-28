public class CircularArrayList extends AbstractArrayList implements CircularCollectible {

    public CircularArrayList() {
        super();
    }

    public CircularArrayList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void add(String s) {

        if (size < arraySize) {
            elements[size] = s;         
            size++;
        } else {
            arraySize = arraySize * 2;
            String[] doubleElements = new String[arraySize];

            for (int i = 0; i < size; i++) {
                doubleElements[i] = elements[i];
            }
            elements[size] = s;
            size++;
        }
    }

    public void remove(String s) {
        int temp = 0;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(s)) {
                temp = i;
                break;
            }

            for (int j = temp; j < elements.length - 1; j++) {
                elements[j] = elements[j + 1];
            }
        }
        size--;
    }
    
    public String first() {
      return elements[0];
    }

    public CircularIterator iterator() {
        return new CircularArrayListIterator();
    }

    class CircularArrayListIterator implements CircularIterator {
        int index;
        String current = "";

        public CircularArrayListIterator() {
            index = 0;
        }
        
        public boolean hasNext() {
            return current != elements[0];
        }

        public String next() {
            if (!hasNext()) throw new UnsupportedOperationException();
            return current = elements[index + 1];
        }

        public void remove(String s) {
            for (int i = index; i < elements.length; i++) {
                elements[i] = elements[i + 1];
            }
            index--;
            size--;
        }

        public String removeKthElement(int k) {
            int count = 0;
            String temp = "";
            String head = elements[0];
            String tail = elements[elements.length - 1];

            for (int i = 0; i < elements.length; i++) {
                count++;
                if (count == k - 1) {
                    temp = elements[i];
                    elements[i] = elements[i + 1];
                    count = 0;
                }

                if (count > elements.length) {
                    i = 0;
                }
            }
            return temp;
        }

        public boolean oneElementLeft() {
            if (size == 1) {
                return true;
            }
            return false;
        }
    }
}
