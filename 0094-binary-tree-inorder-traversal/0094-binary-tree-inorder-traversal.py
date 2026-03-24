# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        def inorder(node, l):
            if not node:
                return l
            
            inorder(node.left, l)
            l.append(node.val)
            inorder(node.right, l)

            return l

        inorder = inorder(root, [])

        return inorder