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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead,
                current = head;
        
        while(current != null && current.next != null) {
            ListNode nextPair = current.next.next;
            ListNode second = current.next;
            current.next = nextPair;
            second.next = current;

            prev.next = second;

            prev = current;
            current = nextPair;

        }

        return dummyHead.next;
    }
}
