# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isMatch(self, node1, node2):
        if not node1 or not node2:
            return False
        return node1.val == node2.val
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not self.isMatch(p, q):
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)