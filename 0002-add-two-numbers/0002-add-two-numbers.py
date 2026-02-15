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
            val = carry + l1.val + l2.val
            node.next = ListNode(val%10)
            node = node.next
            carry = val // 10

            l1 = l1.next
            l2 = l2.next

        if not l1:
            while l2:
                val = carry + l2.val
                node.next = ListNode(val%10)
                node = node.next
                carry = val // 10

                l2 = l2.next
        elif not l2:
            while l1:
                val = carry + l1.val
                node.next = ListNode(val%10)
                node = node.next
                carry = val // 10

                l1 = l1.next
        if carry != 0:
            node.next = ListNode(carry)
            node = node.next
        node.next = None

        return root.next