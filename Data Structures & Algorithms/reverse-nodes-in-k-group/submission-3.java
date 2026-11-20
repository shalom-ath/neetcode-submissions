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

     if(head.next == null) return head;
     if(k == 1) return head;

     //def prev current

     ListNode dummy = new ListNode();
     dummy.next = head;
     ListNode prev = dummy, current = head;

     //reversal

     while(current != null){

        //space 

        boolean space = Checkspace(k, current);

        if(space){
            prev = reversal(k, prev, current);
            current = prev.next;
        }

        else{
            break;
        }
     }

     return dummy.next;   
    }

    private boolean Checkspace(int k, ListNode current){

        for(int i = 1; i <= k; i++){

            if(current == null) return false;
            current = current.next;
        }

        return true;
    }

    private ListNode reversal(int k, ListNode prev, ListNode current){

        for(int i = 0; i < k -1; i++){

            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return current;
    }
}
