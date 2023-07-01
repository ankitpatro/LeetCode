/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> origToCopy = new HashMap<>();
        Node curr = head;

        while(curr != null) {
            Node newNode = new Node(curr.val);
            origToCopy.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;

        while(curr != null) {
            origToCopy.get(curr).next = origToCopy.get(curr.next);
            origToCopy.get(curr).random = origToCopy.get(curr.random);
            curr = curr.next;
        }

        return origToCopy.get(head);
    }
}
