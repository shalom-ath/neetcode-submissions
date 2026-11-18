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

        Queue<ListNode> minheap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode node : lists){

           if(node == null) continue;

           minheap.add(node); 
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(!minheap.isEmpty()){

           ListNode top = minheap.poll();
           current.next = top;
           current = current.next;

            if(top.next != null){
                
                minheap.add(top.next);

            }
        }

        return dummy.next;

    }
}
