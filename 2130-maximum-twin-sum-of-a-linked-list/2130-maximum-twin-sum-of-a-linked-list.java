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
    public int pairSum(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> node = new ArrayList<>();
        int n = 0;
        while(temp!=null){
            node.add(temp.val);
            temp=temp.next;
            n++;
        }
        int i=0,j=n-1;
        int max=Integer.MIN_VALUE;
        while(i<j){
            int sum = node.get(i)+node.get(j);
            System.out.println(sum);
            if(sum>max){
                max = sum;
            }
            i++;
            j--;
        }
        return max;
    }
}