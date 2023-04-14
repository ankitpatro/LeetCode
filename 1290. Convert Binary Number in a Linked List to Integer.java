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
    public int getDecimalValue(ListNode head) {
    //     StringBuilder sb = new StringBuilder();
    //     Stack<Integer> stack = new Stack<>();
    //     while(head != null) {
    //         stack.push(head.val);
    //         head = head.next;
    //     }

    //     int i = 0;
    //     int result = 0;
    //     while(!stack.isEmpty()) {
    //         result += (stack.pop() * Math.pow(2, i++));
    //     }

    //     return result;
    // }
    int num = head.val;

    while(head.next != null) {
        num = num * 2 + head.next.val;
        head = head.next;
    }

    return num;
}
