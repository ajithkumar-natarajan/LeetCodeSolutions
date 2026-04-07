# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        heap = []

        queue = deque([(root)])

        while queue:
            node = queue.popleft()
            heap.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        heapq.heapify(heap)

        for i in range(k):
            if i == k-1:
                return heapq.heappop(heap)
            heapq.heappop(heap)