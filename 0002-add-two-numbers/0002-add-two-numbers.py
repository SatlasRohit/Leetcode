# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        # Convert l1 to string
        a = ""
        while l1:
            a += str(l1.val)
            l1 = l1.next
        
        # Convert l2 to string
        b = ""
        while l2:
            b += str(l2.val)
            l2 = l2.next
        
        # Sum the numbers (reverse strings since digits are in reverse order)
        total = int(a[::-1]) + int(b[::-1])
        
        # Convert result to linked list
        c_str = str(total)[::-1]  # Reverse to match linked list order
        
        # Build result linked list
        dummy = ListNode(0)
        current = dummy
        for digit in c_str:
            current.next = ListNode(int(digit))
            current = current.next
        
        return dummy.next