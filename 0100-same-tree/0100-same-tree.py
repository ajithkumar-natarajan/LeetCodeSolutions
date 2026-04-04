# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        def preorder(node, visited):
            if not node:
                visited.append(None)
                return visited
            
            visited.append(node.val)
            preorder(node.left, visited)
            preorder(node.right, visited)

            return visited

        if preorder(p, []) == preorder(q, []):
            return True
        return False