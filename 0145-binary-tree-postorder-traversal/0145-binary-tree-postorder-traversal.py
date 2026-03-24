# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def postorder(node, visited):
            if not node:
                return visited
            
            postorder(node.left, visited)
            postorder(node.right, visited)
            visited.append(node.val)

            return visited
        
        visited = postorder(root, [])

        return visited