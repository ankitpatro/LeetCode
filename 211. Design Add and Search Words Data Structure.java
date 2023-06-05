class WordDictionary {
    Node root;

    class Node {
        char character;
        Map<Character, Node> children;
        boolean isWord;

        public Node(char c, Map<Character, Node> children) {
            this.character = c;
            this.children = children;
        }

    }


    public WordDictionary() {
        root = new Node('#', new HashMap<>());
    }
    
    public void addWord(String word) {
        Node current = root;
        for(char c : word.toCharArray()) {

            if(!current.children.containsKey(c)) {
                current.children.put(c, new Node(c, new HashMap<>()));
            }

            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) { 
        return searchInNode(word, this.root);
    }
    
    public boolean searchInNode(String word, Node root) {
        Node current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!current.children.containsKey(c)) {

                if( c == '.') {
                    for(char x : current.children.keySet()) {
                        Node child = current.children.get(x);
                        if(searchInNode(word.substring(i+1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            current = current.children.get(c);
        }
        return current.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
