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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
        Queue<TreeNode> qleft = new LinkedList<>();
        // Queue<TreeNode> qright = new LinkedList<>();
        qleft.offer(root);
        
        while(!qleft.isEmpty()){
            int len = qleft.size();
            
            for(int i=0; i<len; ++i){
                TreeNode node = qleft.poll();
                // TreeNode nodeLeft = qleft.poll();
                // TreeNode nodeRight = qright.poll();
                if(node.left != null)
                    qleft.offer(node.left);
                if(node.right != null)
                    qleft.offer(node.right);
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                // if(node.right != null)
                //     qright.offer(node.right);
                // if(node.left != null)
                //     qright.offer(node.left);
                
                // System.out.println(node.val);
            }
            // System.out.println(qright);
            
        }
        
        return root;
    }
}