class Trie {
    class Node {
        char c;
        Map<Character, Node> children;
        boolean isWord;

        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
            isWord = false;
        }
    }

    Node head;
    public Trie() {
         head = new Node('\0');
    }
    
    public void insert(String word) {
        Node current = head;
        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                current.children.put(c, new Node(c));
            }
            current = current.children.get(c);
        }

        current.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = getNode(word);
        if(node != null && node.isWord == true) {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    public Node getNode(String word) {
        Node current = head;

        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                return null;
            }

            current = current.children.get(c);

        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
