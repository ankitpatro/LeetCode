class MyHashSet {

    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }

        public Node() {

        }
    }

    Node[] list;
    int size;

    public MyHashSet() {
        size = 1000;
        list = new Node[size];

        for(int i = 0; i < size; i++) {
            list[i] = new Node();
        }
    }

    private int getIndex(int key) {
        return key % 1000; 
    }
    
    public void add(int key) {
        int index = getIndex(key);
        Node node = list[index];

        while(node.next != null) {
            if(key == node.next.key) {
                return;
            }
            node = node.next;
        }

        node.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node node = list[index];

        while(node != null && node.next != null) {
            if(node.next.key == key) {
                node.next = node.next.next;
            }
            node = node.next;
        }
    }
    
    public boolean contains(int key) {
        int index = getIndex(key);
        Node node = list[index];

        while(node != null && node.next != null) {
            if(node.next.key == key) {
                return true;
            }
            node = node.next;
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
