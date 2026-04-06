# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        left = head
        dummy = head

        llist = []

        while dummy:
            llist.append(dummy)
            dummy = dummy.next

        if len(llist) < 2:
            return head

        i, j = 1, len(llist)-1

        while i<=j:
            left.next = llist[j]
            left.next.next = llist[i]
            left = llist[i]
            i += 1
            j -= 1
        left.next = None
        
        return llist[0]