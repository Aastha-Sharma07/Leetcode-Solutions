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
    public int[] nextLargerNodes(ListNode head) {
        
        // Step 1: Find size
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] answer = new int[size];

        // Step 2: For each node, find next greater
        ListNode curr = head;
        int i = 0;

        while (curr != null) {
            ListNode next = curr.next;

            while (next != null && next.val <= curr.val) {
                next = next.next;
            }

            if (next != null) {
                answer[i] = next.val;
            } else {
                answer[i] = 0;
            }

            curr = curr.next;
            i++;
        }

        return answer;
    }
}