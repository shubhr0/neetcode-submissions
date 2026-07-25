class MyHashMap {

    class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode[] set;

    public MyHashMap() {
        set = new ListNode[10001];

        for(int i = 0; i < set.length; i++) {
            set[i] = new ListNode(-1, -1); // dummy node
        }
    }

    public void put(int key, int value) {
        ListNode curr = set[key % set.length];

        while(curr.next != null) {
            if(curr.next.key == key) {
                curr.next.value = value;
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key, value);
    }

    public int get(int key) {
        ListNode curr = set[key % set.length];

        while(curr.next != null) {
            if(curr.next.key == key) {
                return curr.next.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        ListNode curr = set[key % set.length];

        while(curr.next != null) {
            if(curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}