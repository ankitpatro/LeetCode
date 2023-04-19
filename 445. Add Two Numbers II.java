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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode next = null;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int val = (x + y + carry) % 10;
             carry  = (x + y + carry) / 10;

            ListNode current = new ListNode(val);
            current.next = next;
            next = current;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 ==null ? null : l2.next;
        }

        if(carry > 0) {
            ListNode current = new ListNode(carry);
            current.next = next;
            next = current;
        }
        return next;
    }

    private ListNode reverse(ListNode l) {
       ListNode prev = null;

       while(l != null) {
           ListNode next = l.next;
           l.next = prev;
           prev = l;
           l = next;
       }
       
        return prev;

    }
}
