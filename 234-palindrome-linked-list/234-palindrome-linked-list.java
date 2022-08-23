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
    ListNode reverse(ListNode root){
        ListNode next = root, prev = null, curr = null;
        while(next != null){
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast != null) slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode head2 = reverse(temp);
        ListNode curr = head, curr2 = head2;
        while(curr != null && curr2 != null){
            if(curr.val != curr2.val) return false;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return true;
    }
}