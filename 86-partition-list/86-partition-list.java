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
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        ListNode temp = new ListNode(-1);
        temp.next= head;
        ListNode dummy = temp;
        while(dummy != null && dummy.next != null){
            if(dummy.next.val < x){
                curr.next = dummy.next;
                dummy.next = dummy.next.next;
                curr = curr.next;
            }
            else
                dummy = dummy.next;
        }
        curr.next = temp.next;
        return newHead.next;
    }
}