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
        if(head == null) return null;
        Node curr = head;
        while(curr != null){
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random == null){
                curr.next.random = null;
            }
            else{
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        Node newHead = head.next;
        curr = newHead;
        while(curr.next != null){
            head.next = head.next.next;
            head = head.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        head.next = null;
        return newHead;
    }
}