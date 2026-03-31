# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:

        # def dfs(node, n):
        #     if not node:
        #         return

        #     n = 2*n + node.val
        #     if not node.left and not node.right:
        #         self.ans += n

        #     dfs(node.left, n)
        #     dfs(node.right, n)

        # self.ans = 0
        # dfs(root, 0)

        # return self.ans

        # Enter your code here. Read input from STDIN. Print output to STDOUT
        """
        # ORACLE INTERVIEW:
                0
            1   1
            0 1
        010 + 011 + 01

        [[0]] -> [[010, 010]]

        [0, 1, 0]

        """

        total = 0
        def dfs_sum(node, binary):
            nonlocal total
            binary.append(str(node.val))
            if not node.left and not node.right:
                binary_string = ''.join(binary)
                total += int(binary_string, 2)
            if node.left:
                dfs_sum(node.left, binary) #-> binary=[0, 1, 0], total=2
            if node.right:
                dfs_sum(node.right, binary)
            
            binary.pop()

        if not root:
            return 0
        dfs_sum(root, [])

        return total