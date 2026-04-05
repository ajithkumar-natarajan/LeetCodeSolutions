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
        q = deque([node])

        while q:
            n = q.popleft()
            if n.val not in node_dict:
                node_dict[n.val] = Node(n.val)
            neigh = []
            for neighbor in n.neighbors:
                if neighbor.val not in node_dict:
                    node_dict[neighbor.val] = Node(neighbor.val)
                neigh.append(node_dict[neighbor.val])
                if neighbor not in visited:
                    q.append(neighbor)
                    visited.add(neighbor)
            node_dict[n.val].neighbors = neigh


        return node_dict[1]