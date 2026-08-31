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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] result = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int pos = 1;
        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {

            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (first == -1) {
                    first = pos;
                } else {
                    minDist = Math.min(minDist, pos - last);
                }

                last = pos;
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (first == -1 || first == last) {
            return result;
        }

        int maxDist = last - first;

        return new int[]{minDist, maxDist};
    }
}