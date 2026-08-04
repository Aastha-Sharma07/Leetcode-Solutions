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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while(temp !=null){
            temp = temp.next;
            size++;
        }  

        if(n==size){
            return head.next;
        }

        int n_last = size-n;
        ListNode prev = head;
        int i=1;
        while(i<n_last){
            prev = prev.next;
            i++;
        }    

        prev.next = prev.next.next;
        return head;
    }
}