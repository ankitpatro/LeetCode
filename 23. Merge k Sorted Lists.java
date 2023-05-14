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
    public ListNode mergeKLists(ListNode[] lists) {

    // ----------------Divide & Conquer------------------ 
    //     if(lists == null || lists.length == 0) {
    //         return null;
    //     }
    //     int start = 0;
    //     int end = lists.length - 1;

    //     return divideAndMerge(lists, start, end);
    // }

    // private ListNode divideAndMerge(ListNode[] lists, int start, int end) {
    //     if(start == end) {
    //         return lists[start];
    //     }
    //     int mid = start + (end - start)/2;

    //     ListNode left = divideAndMerge(lists, start, mid);
    //     ListNode right = divideAndMerge(lists, mid + 1, end);

    //     return merge(left, right);
    // }

    // private ListNode merge(ListNode l1, ListNode l2) {
    //     ListNode head = new ListNode(-1);
    //     ListNode current = head;

    //     while(l1 != null || l2 != null) {
    //         if(l1 == null) {
    //             current.next = l2;
    //             l2 = l2.next;
               
    //         }

    //         else if(l2 == null) {
    //             current.next = l1;
    //             l1 = l1.next;
    //         }

    //         else if(l1.val < l2.val) {
    //                 current.next = l1;
    //                 l1 = l1.next;
    //             }

    //             else {
    //                 current.next = l2;
    //                 l2 = l2.next;
    //             }
    //             current = current.next;
    //         }
    //         return head.next;
    //     }

    // ____________________Using Min Heap_____________________

    Queue<ListNode> pq = new PriorityQueue<>((l1, l2) -> {
        return l1.val - l2.val;
    });

    for(ListNode listNode  : lists) {
        if(listNode != null)
        pq.offer(listNode);
    }

    ListNode head = new ListNode(-1);
    ListNode current = head;

    while(!pq.isEmpty()) {
        ListNode top = pq.poll();
        current.next = top;
        if(top.next != null) {
            pq.offer(top.next);
        }
        current = current.next;
    }
        return head.next;
    }
}
