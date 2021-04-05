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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        // return helper(root);
        List<Integer> list = new ArrayList<>();
        list = dfs(root, list);
        
        for(int i=0; i<list.size()-1; ++i)
            if(list.get(i) >= list.get(i+1))
                return false;
        
        return true;
    }
    
    List<Integer> dfs(TreeNode node, List<Integer> list){
        if(node == null)
            return list;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
        
        return list;
    }
    
//     private boolean helper(TreeNode node){
        
//         if(node.left != null && node.left.val < node.val){
//             helper(node.left);
//         }
//         else
//             if(node.left != null)
//                 return false;
        
//         if(node.right != null && node.right.val > node.val){
//             helper(node.right);
//         }
//         else
//             if(node.right != null)
//                 return false;
        
        
//         return true;
//     }
}