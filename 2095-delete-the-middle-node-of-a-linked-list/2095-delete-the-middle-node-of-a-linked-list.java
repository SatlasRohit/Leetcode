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
        ListNode temp = head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        if(n<2) return head = null;
        int mid = n/2;
        int count =0 ;
        temp = head;
        while(count<mid-1){
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp = head;
        return temp;
    }
}