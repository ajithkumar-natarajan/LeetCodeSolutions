# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        queue = deque([(root, 0)])
        ans = 0

        while queue:
            l = len(queue)

            for _ in range(l):
                node, node_val = queue.popleft()

                if node.left or node.right:
                    if node.left:
                        queue.append((node.left, node_val*10 + node.val))
                    if node.right:
                        queue.append((node.right, node_val*10 + node.val))
                else:
                    ans += node_val*10 + node.val

        return ans