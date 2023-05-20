/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();

       return dfs(node, map);
       // return map.get(node);
    }

    private Node dfs(Node oldNode, Map<Node, Node> map) {
        if(!map.containsKey(oldNode)) {
            Node newNode = new Node(oldNode.val, new ArrayList<Node>());
            map.put(oldNode, newNode);
               for(Node neighbor : oldNode.neighbors) {
                   newNode.neighbors.add(dfs(neighbor, map));
            }
        }

        return map.get(oldNode);

     
    }
}
