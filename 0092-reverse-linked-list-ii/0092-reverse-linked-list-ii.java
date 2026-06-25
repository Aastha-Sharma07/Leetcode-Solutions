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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right){
            return head;
        } 
        
        ListNode prev = null;
        ListNode curr = head;

        int i =1;

        while(curr != null && i != left){
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode pointerToStart = prev;
        ListNode start = curr;

        prev = null;

        while(curr != null && i != right+1){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if(pointerToStart != null){
            pointerToStart.next = prev;
        }else{
            head = prev;
        }
        start.next = curr;

        return head;
    }
}