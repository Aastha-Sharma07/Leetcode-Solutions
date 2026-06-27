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
 import java.util.*;
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] answer = new int[size];
        int[] arr = new int[size];
        
        temp = head;
        int j = 0;
        while(j < size && temp != null){
            arr[j] = temp.val;
            temp = temp.next;
            j++;
        }

        Stack<Integer> s = new Stack<> ();

        for(int i = size-1; i>=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                answer[i] = 0;
            }else{
                answer[i] = arr[s.peek()];
            }
            s.push(i);
        }

        return answer;
    }
}