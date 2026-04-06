# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head.next and n == 1:
            return None

        llist = []

        dupl = head

        while dupl:
            llist.append(dupl)
            dupl = dupl.next

        dupl = head
        if llist[0] == llist[-n]:
            head = head.next
            dupl = None
            return head

        while dupl:
            if dupl.next == llist[-n]:
                print("inside")
                dupl.next = dupl.next.next
            dupl = dupl.next
        return head