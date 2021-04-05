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
    public void flatten(TreeNode root) {
        Queue<Integer> q = new LinkedList<>();
        q = dfs(root, q);
        
        // System.out.println(q);
        
        while(!q.isEmpty()){
            int i = q.poll();
            if(root != null){
                root.val = i;
                root.left = null;
                if(root.right != null)
                    root = root.right;
                else
                    break;
                continue;
            }
        }
        
        while(!q.isEmpty()){
            int i = q.poll();
            root.right = new TreeNode(i);
            root = root.right;
        }
    }
    Queue<Integer> dfs(TreeNode node, Queue<Integer> q){
        if(node == null)
            return q;
        
        q.add(node.val);
        dfs(node.left, q);
        dfs(node.right, q);
        
        return q;
    }
    
}