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
    public TreeNode convertBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> qu = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        if(root == null)
            return root;
        
        q.offer(root);
        qu.add(root.val);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!qu.contains(node.val))
                qu.add(node.val);
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null)
                q.offer(node.right);
        }
        
        System.out.println(qu);
        
        Collections.sort(qu, Collections.reverseOrder());
        
        System.out.println(qu);
        
        int sum = 0;
        for(int i: qu){
            sum += i;
            map.put(i, sum);
        }
        
        System.out.println(map);
        
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            node.val = map.get(node.val);
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null)
                q.offer(node.right);
        }
        
        return root;
    }
}