
class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private Node[] hashTable;

    public MyHashSet() {
        hashTable = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    private int hashFunction(int key, int capacity) {
        return Math.floorMod(key, capacity);
    }

    public void add(int key) {
        int index = hashFunction(key, hashTable.length);

        // Check for duplicates first
        Node current = hashTable[index];

        while (current != null) {
            if (current.key == key) {
                return;
            }
            current = current.next;
        }

        // Resize before inserting if necessary
        if ((double) (size + 1) / hashTable.length > LOAD_FACTOR) {
            resize();
            index = hashFunction(key, hashTable.length);
        }

        // Insert at the beginning of the bucket
        hashTable[index] = new Node(key, hashTable[index]);
        size++;
    }

    public void remove(int key) {
        int index = hashFunction(key, hashTable.length);
        Node current = hashTable[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    hashTable[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = hashFunction(key, hashTable.length);
        Node current = hashTable[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private void resize() {
        if (hashTable.length > Integer.MAX_VALUE / 2) {
            throw new IllegalStateException("Maximum capacity reached");
        }

        Node[] newTable = new Node[hashTable.length * 2];

        for (Node head : hashTable) {
            Node current = head;

            while (current != null) {
                Node next = current.next;

                int index = hashFunction(current.key, newTable.length);

                // Reuse the existing node
                current.next = newTable[index];
                newTable[index] = current;

                current = next;
            }
        }

        hashTable = newTable;
    }

    public int size() {
        return size;
    }
}
