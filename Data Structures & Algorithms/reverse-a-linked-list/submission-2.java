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
    public ListNode reverseList(ListNode head) {
        
        //edge case

        if(head == null) return head;

        ListNode prev = null, current = head, next = current.next;

        while(current != null){

            current.next = prev;
            prev = current;
            current = next;

            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }
}
