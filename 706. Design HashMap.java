class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this. val = val;
        }
    }

    Node[] list;
    int offset;

    public MyHashMap() {
        
        offset = 1000;
        list = new Node[offset];
    }
    
    public void put(int key, int value) {
        int index = key % offset;

        Node node = list[index];
        if(node == null) {
            list[index] = new Node(key, value);
            return;
        }

        Node prev = node;

        while(node != null) {
            if(node.key == key) {
                node.val = value;
                return;
            }
            prev = node;
            node = node.next;
        }
        prev.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = key % offset;
        Node node = list[index];
        while(node != null) {
            if(node.key == key) {
                return node.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % offset;
        Node node = list[index];
        if(node == null) {
            return;
        }

        if(node != null && node.key == key) {
            list[index] = node.next;
        }
        Node prev = node;
        node = node.next;
        while(node != null) {
            if(node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
