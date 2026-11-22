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
    public ListNode reverseKGroup(ListNode head, int k) {

        //edge case
        
        if(head.next == null && k == 1){

            return head;

        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevgroup = dummy;

        while(true){

            ListNode lastnode = prevgroup;

            for(int i = 0; i < k && lastnode != null; i++){

                lastnode = lastnode.next;
            }

            if(lastnode == null){

                break;
            }

            ListNode groupnext = lastnode.next;
            ListNode prev = groupnext;
            ListNode current = prevgroup.next;


            while(current != groupnext){

                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;

            }

            ListNode oldgrouphead = prevgroup.next;
            prevgroup.next = lastnode;
            
            prevgroup = oldgrouphead;
        }


        return dummy.next;

        
    }
}
