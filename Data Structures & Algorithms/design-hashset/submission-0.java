class MyHashSet {

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private final ListNode[] set;

    public MyHashSet() {
        set = new ListNode[10000];
    }

    private int hash(int key) {
        return Math.floorMod(key, set.length);
    }

    public void add(int key) {
        int index = hash(key);
        ListNode cur = set[index];

        while (cur != null) {
            if (cur.key == key) {
                return; // Already exists
            }
            cur = cur.next;
        }

        // Insert at the beginning
        ListNode node = new ListNode(key);
        node.next = set[index];
        set[index] = node;
    }

    public void remove(int key) {
        int index = hash(key);
        ListNode cur = set[index];
        ListNode prev = null;

        while (cur != null) {
            if (cur.key == key) {

                if (prev == null) {
                    // Removing the first node
                    set[index] = cur.next;
                } else {
                    // Removing a middle or last node
                    prev.next = cur.next;
                }

                return;
            }

            prev = cur;
            cur = cur.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        ListNode cur = set[index];

        while (cur != null) {
            if (cur.key == key) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */