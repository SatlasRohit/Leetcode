class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // dummy node
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;   // move forward
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;   // move forward
            }

            carry = sum / 10;           // get carry
            temp.next = new ListNode(sum % 10); // create new node
            temp = temp.next;           // move temp
        }

        return dummy.next; // skip dummy
    }
}