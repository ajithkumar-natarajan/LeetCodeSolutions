# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        def build(preorder, inorder):
            if inorder:
                x = preorder.pop(0)
                index = inorder.index(x)

                node = TreeNode(inorder[index])

                node.left = build(preorder, inorder[0:index])
                node.right = build(preorder, inorder[index+1:len(inorder)])

                return node

        return build(preorder, inorder)