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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
       
        List<Integer> ans = new ArrayList<>();
        return postOrder(root, ans);
    }
   
    List<Integer> postOrder(TreeNode node, List<Integer> list){
        if(node.left != null)
            postOrder(node.left, list);
        if(node.right != null)
            postOrder(node.right, list);
        list.add(node.val);
       
        return list;
    }
}