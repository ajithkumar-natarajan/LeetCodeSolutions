# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return -1
        
        totals = []
        queue = []
        queue.append([root])

        while queue:
            nodes = queue.pop(0)
            level = []
            total = 0
            
            for node in nodes:
                total += node.val
                if node.left:
                    level.append(node.left)
                if node.right:
                    level.append(node.right)
            if level:
                queue.append(level)
            totals.append(total)

        if len(totals) < k:
            return -1
        totals.sort()

        return totals[len(totals)-k]