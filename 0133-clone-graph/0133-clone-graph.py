"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return
        
        node_dict = {}
        visited = set()
        val = 1
        max_val = 1
        q = deque([node])

        while q:
            n = q.popleft()
            if n.val not in node_dict:
                node_dict[n.val] = Node(n.val)
            for neighbor in n.neighbors:
                if neighbor not in visited:
                    q.append(neighbor)
                    visited.add(neighbor)

        for n in visited:
            neighbor = []
            for no in n.neighbors:
                neighbor.append(node_dict[no.val])
            node_dict[n.val].neighbors = neighbor


        return node_dict[1]
