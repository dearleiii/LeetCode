class LRUCache {
    class ListNode {
        public int key, value;
        public ListNode next; 
        
        // initializer 
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Map<Integer, ListNode> keytoPrev;
    private int size, capacity;
    ListNode dummy, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keytoPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = dummy;
    }
    
    public int get(int key) {
        if (!keytoPrev.containsKey(key)) {
            return -1;
        }
        
        // if contains key, return value +. update node position
        movetoTail(key);
        return tail.val;
    }
    
    private void movetoTail(int key) {
        ListNode prev = keytoPrev.get(key);
        if (tail == prev.next)
            return;
        
        // move 
        tail.next = prev.next;
        tail = tail.next;
        prev.next = prev.next.next;
        
        return;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) { // key already in list, only update value 
            keytoPrev.get(key).next.val = value;
            return;
        }
        
        // getKey == -1
        // if size satisfied 
        if (size == capacity) {
            // remove lru node 
            
        }
        
        // no need to remove, only add
        size++;
        ListNode curr = new ListNode(key, value);
        tail.next = curr;
        
        keytoPrev.put(key, tail);
        tail = tail.next;
        
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
