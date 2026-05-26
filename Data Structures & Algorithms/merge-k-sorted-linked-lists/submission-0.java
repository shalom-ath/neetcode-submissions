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

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode node : lists){

            if(node == null) continue;

            minHeap.offer(node);
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(!minHeap.isEmpty()){

            ListNode top = minHeap.poll();

            current.next = top;

            current = current.next;

            if(top.next != null){

                minHeap.offer(top.next);
            }

        }

        return dummy.next;
        

    }
}
