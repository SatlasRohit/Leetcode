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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null){
            fast = fast.next;
            count++;
        }
        int div = count/2;
        count =0;
        while(count < div){
            slow = slow.next;
            count++;
        }
        return slow;
    }
}