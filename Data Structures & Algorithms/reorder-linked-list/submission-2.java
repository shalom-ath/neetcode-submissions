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

    public ListNode middle(ListNode head){

        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

        }

        return slow;
    }

    //reversal

    public ListNode reversal(ListNode head){

        if(head == null || head.next == null){

            return head;
        }

            ListNode prev = null;
            ListNode current = head;
            ListNode next = current.next;

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

    public void reorderList(ListNode head) {

        if(head == null){

            return;
        }

        ListNode mid = middle(head);
        ListNode hf = head;
        ListNode hs = reversal(mid);


        while(hf != null && hs != null){

            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if(hf != null){

            hf.next = null;
        }
     
    }
}
