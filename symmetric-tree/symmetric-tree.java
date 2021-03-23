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
    public boolean isSymmetric(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null))
            return true;
        
//         Deque<TreeNode> q = new ArrayDeque<>();
//         // q.offer(root);
        
//         if(root.left != null)
//             q.offer(root.left);
//         if(root.right != null)
//             q.offer(root.right);
        
//         while(!q.isEmpty()){
//             int n = q.size();
            
//             // System.out.println(q);
            
//             if(n%2 != 0)
//                 return false;
            
//             for(int i=0; i<n/2; ++i){
//                 boolean flag = true;
//                 // System.out.println(q.size());
//                 TreeNode n1 = q.poll();
//                 // System.out.println(q.size());
//                 TreeNode n2 = q.pop();
//                 System.out.println(n1.val);
//                 System.out.println(n2.val);
//                 if(n1.val != n2.val)
//                     return false;
//                 if(n1.left != null){
//                     q.offer(n1.left);
//                     flag = false;
//                 }
//                 if(n1.right != null){
//                     q.offer(n1.right);
//                     if(flag)
//                         return false;
//                     else
//                         flag = true;
//                 }
//                 if(n2.left != null){
//                     q.offer(n2.left);
//                     if(!flag)
//                         return false;
//                     else
//                         flag = false;
//                 }
//                 if(n2.right != null){
//                     q.offer(n2.right);
//                     if(flag)
//                         return false;
//                     else
//                         flag = true;
//                 }
//             }
//         }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root.left != null){
            if(root.right == null)
                return false;
            q.offer(root.left);
            q.offer(root.right);
        }
        else if(root.right != null)
            return false;
        
        while(q.size() > 0){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left.val != right.val)
                return false;
            
            if(left.left != null){
                if(right.right == null)
                    return false;
                q.offer(left.left);
                q.offer(right.right);
            }
            else if(right.right != null)
                return false;
            
            if(left.right != null){
                if(right.left == null)
                    return false;
                q.offer(left.right);
                q.offer(right.left);
            }
            else if(right.left != null)
                return false;
        }
        
        return true;
        
    }
}