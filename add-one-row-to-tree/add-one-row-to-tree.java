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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)
            return root;
        
        int level = 1;
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2   = new LinkedList<>();
        q.offer(root);
        
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
            
        
        while(!q.isEmpty() && !flag){
            int len = q.size();
            
            for(int i=0; i<len; ++i){
                TreeNode node = q.poll();
                
                if(level+1 == d){
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    
                    // if(node.left != null){
                        node.left = new TreeNode(v);
                        node.left.left = left;
                    // }
                    // if(node.right != null){
                        node.right = new TreeNode(v);
                        node.right.right = right;
                    // }
                    
                    // node.left = left;
                    // node.right = right;
                    
                    flag = true;
                    
                }
            
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            ++level;
        }
        return root;
    }
}