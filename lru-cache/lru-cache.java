class LRUCache {
    Map<Integer, Node> keyLinkedListMap;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    
    public LRUCache(int capacity) {
        keyLinkedListMap = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        
        // System.out.println(head.val);
        // System.out.println(tail.val);
    }
    
    public int get(int key) {
        // System.out.println("get" + head.next.val);
        // System.out.println(head.next.next.val);
        if(keyLinkedListMap.containsKey(key)){
            Node node = keyLinkedListMap.get(key);
            int val = node.val;
            if(keyLinkedListMap.size() > 1 && node.prev != head)
                moveNodeToRecent(node);
            
            return val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
         // System.out.println("put" + head.next.val);
        // System.out.println(head.next.next.val);
        if(keyLinkedListMap.containsKey(key)){
            Node node = keyLinkedListMap.get(key);
            node.val = value;
            
            if(keyLinkedListMap.size() > 1 && node.prev != head)
                moveNodeToRecent(node);
            
            return;
        }
        
        if(keyLinkedListMap.size() == capacity){
            removeLeastRecentNode();
        }
        Node node = new Node(key, value);
        keyLinkedListMap.put(key, node);
        moveNodeToRecent(node);
        return;
    }
    
    private void moveNodeToRecent(Node node){
        if(node.prev != null && node.next != null){  
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;        
    }
    
    private void removeLeastRecentNode(){
        Node node = tail.prev;
        // System.out.println("removing "+node.val);
        keyLinkedListMap.remove(node.key);
        node.prev.next = tail;
        tail.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    private class Node{
        Node prev, next;
        int key;
        int val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */