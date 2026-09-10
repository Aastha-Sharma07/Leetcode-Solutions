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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int size = 0;
        ListNode temp = head;

        while(temp!=null){
            size++;
            temp = temp.next;
        }
        int mid = size/2;
        int i=1;
        ListNode prev = head;

        while(i<mid){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;
    }
}