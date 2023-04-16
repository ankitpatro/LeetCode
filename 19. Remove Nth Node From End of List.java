/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode current = head;
       for(int i = 0; i < n ; i++) {
           current = current.next;
       }

       if(current == null) 
        return head.next;

        ListNode nodeBeforeRemoved = head;

        while(current.next != null) {
            current = current.next;
            nodeBeforeRemoved = nodeBeforeRemoved.next;
        }

        nodeBeforeRemoved.next = nodeBeforeRemoved.next.next;

        return head;
    }
}
