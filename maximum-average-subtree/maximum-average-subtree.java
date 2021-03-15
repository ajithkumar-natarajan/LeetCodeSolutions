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
    double max = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        // Map<TreeNode, Double> map = new HashMap<>();
        
        helper(root);
        
        return max;
    }
    
    double[] helper(TreeNode node){
        // System.out.println(max);
        if(node == null)
            return new double[]{0,0};
        int tot = node.val;
        double count = 1;
        if(node.left != null){
            double[] ret = helper(node.left);
            tot += ret[0];
            count += ret[1];
        }
        if(node.right != null){
            double[] ret = helper(node.right);
            tot += ret[0];
            count += ret[1];
            // max = Math.max(tot/count, ret[2]);
        }
        
        max = Math.max(tot/count, max);
        
        // System.out.println(Arrays.toString(new double[]{tot, count})+" "+max);
        
        return new double[]{tot, count};
    }
}