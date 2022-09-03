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
    void reverse(ListNode head){
        ListNode prev = null, curr = null, next = head;
        while(next != null){
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode  newHead = new ListNode(-1);
        ListNode temp = newHead;
        ListNode curr = head;
        ListNode prev = head;
        while(curr != null){
            int i = 0; 
            while(curr != null && i < k-1){
                i++;
                curr = curr.next;
            }
            if(i == k-1 && curr != null){
                temp.next = curr;
                curr = curr.next;
                temp.next.next = null;
                temp = prev;
                reverse(prev);
            }
            else{
                temp.next = prev;
                break;
            }
            prev = curr;
        }
        return newHead.next;
    }
}