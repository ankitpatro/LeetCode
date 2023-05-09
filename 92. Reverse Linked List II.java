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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode dummy = new ListNode(-1, head);

        while(left > 1) {
            prev = current;
            current = current.next;
            left--;
            right--;
        }

        ListNode leftPrev = prev;
        ListNode tail = current;

        ListNode third = null;

        while(right > 0) {
            third = current.next;
            current.next = prev;

            prev = current;
            current = third;
            right--;
        }

        if(leftPrev != null) {
            leftPrev.next = prev;
        }
        else {
            head = prev;
        }

        tail.next = current;
        return head;
    }
}
