# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def isMatch(self, node1, node2):
    #     if not node1 or not node2:
    #         return False
    #     return node1.val == node2.val
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # if not p and not q:
        #     return True
        # if not self.isMatch(p, q):
        #     return False
        # return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

        queue = deque([(p, q)])

        while queue:
            node1, node2 = queue.popleft()

            if not node1 and not node2:
                continue
            
            if not node1 or not node2 or node1.val != node2.val:
                return False
            
            queue.append((node1.left, node2.left))
            queue.append((node1.right, node2.right))

        return True