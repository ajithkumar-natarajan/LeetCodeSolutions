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
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
//         boolean flag = false;
        
        if(root != null)
            q.offer(root);
        else
            return ans;
        
//         while(q.size() > 0){
//             int len = q.size();
            
//             for(int i=0; i<len; ++i){
//                 TreeNode node = q.poll();
//                 if(node.left != null)
//                     q.offer(node.left);
                
//                 if(node.right != null)
//                     q.offer(node.right);
                
//                 if(i == 0 && node.left == null && node.right == null && flag)
//                     ans += node.val;
                
//                 // System.out.println(q);
//             }
            
//             flag = true;
//         }
        
        while(q.size()>0){
            TreeNode node = q.poll();
            
            if(node.left != null)
                if(node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    q.offer(node.left);
            
            if(node.right != null)
                if(node.right.left != null || node.right.right != null)
                    q.offer(node.right);
        }
        
        return ans;
    }
}