# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        answer = 0
        def max_level(node, count):
            if not node:
                return count
            nonlocal answer
            
            answer = max(answer, max(max_level(node.left, count+1), max_level(node.right, count+1)))
            return answer

        max_level(root, 0)
        return answer