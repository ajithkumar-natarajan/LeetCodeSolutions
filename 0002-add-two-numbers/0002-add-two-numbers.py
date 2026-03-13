# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        node = ListNode()
        root = node
        carry = 0

        while l1 and l2:
            val = l1.val + l2.val + carry
            root.next = ListNode(val%10)
            root = root.next
            carry = val // 10

            l1 = l1.next
            l2 = l2.next

        while l1:
            val = l1.val + carry
            root.next = ListNode(val%10)
            root = root.next
            carry = val // 10

            l1 = l1.next
        
        while l2:
            val = l2.val + carry
            root.next = ListNode(val%10)
            root = root.next
            carry = val // 10

            l2 = l2.next

        if carry:
            root.next = ListNode(carry)
            root = root.next

        return node.next