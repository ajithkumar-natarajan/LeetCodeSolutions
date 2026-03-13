# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        def preorder(node, visited):
            if not node:
                return visited
            visited.append(node.val)
            preorder(node.left, visited)
            preorder(node.right, visited)

            return visited

        return preorder(root, [])
            
    #     # if root == None:
    #     #     return list()
    #     result = list()

    #     self.bfs([root], result)

    #     return result

    # def bfs(self, queue, result):
    #     while queue:
    #         node = queue.pop()
    #         if not node:
    #             return
    #         result.append(node.val)
    #         # print(result)

    #         if node.right != None:
    #             queue.append(node.right)
    #             # print("right", queue)
    #         if node.left != None:
    #             queue.append(node.left)
    #             # print("left", queue)

    # def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    #     result = list()
    #     self.traverseRecursively(root, result)

    #     return result

    # def traverseRecursively(self, root, result):
    #     if root == None:
    #         return result
    #     result.append(root.val)
    #     self.traverseRecursively(root.left, result)
    #     self.traverseRecursively(root.right, result)

    # def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    #     result = []
    #     self.bfs(root, result)
        
    #     return result
    
    # def bfs(self, root, result):
    #     if root:
    #         result.append(root.val)
    #         self.bfs(root.left, result)
    #         self.bfs(root.right, result)
        
    #     return result