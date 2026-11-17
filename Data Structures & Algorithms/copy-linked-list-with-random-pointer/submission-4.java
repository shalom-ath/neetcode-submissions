/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        //edge case
        if(head == null) return null;

        //intialise dupe nodes 

        Node current = head;

        while(current != null){

            Node newnode = new Node(current.val);
            newnode.next = current.next;
            current.next = newnode;
            current = newnode.next;
        }

        //copying random 

        current = head;

        while(current != null){

            if(current.random != null)

            current.next.random = current.random.next;
            current = current.next.next;

            
        }

        //seperating the ogs from dupe

        current = head;

            Node newhead = head.next;
            Node newcurr = newhead;

        while(current != null){

            current.next = newcurr.next;
            current = current.next;

            if(current != null){

                newcurr.next = current.next;
                newcurr = newcurr.next;
            }
        }    

        return newhead;   
    }
}
