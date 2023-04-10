/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }
        Node current = head;
        while(current != null) {
            if(current.child == null) {
                current = current.next;
                continue;
            }

            else {
                Node currentNext = current.next;
                Node childTail = dfs(current.child);
                current.next = current.child;
                current.child = null;
                current.next.prev = current;
                childTail.next = currentNext;
               if(currentNext != null) currentNext.prev = childTail;
            }
            current = current.next;
        }

        return head;
    }

    private Node dfs(Node child) {
        while(child.next != null) {
            child = child.next;
        }
        return child;
    }
}
