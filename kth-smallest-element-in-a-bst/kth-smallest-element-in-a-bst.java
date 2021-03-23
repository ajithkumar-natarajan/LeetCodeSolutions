/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        List<Integer> list = inorderTraverse(root, new ArrayList<>());
        
        return list.get(k-1);
    }
   
    List<Integer> inorderTraverse(TreeNode node, List<Integer> list){
        if(node.left != null)
            inorderTraverse(node.left, list);
        list.add(node.val);
        if(node.right != null)
            inorderTraverse(node.right, list);
       
        return list;
       
    }
}