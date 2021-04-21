/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        
        ans.add(root.val);
        Collections.reverse(root.children);
        for(Node n: root.children)
            q.addFirst(n);
        
        while(q.size()>0){
            Node node = q.removeFirst();
            ans.add(node.val);
            
            if(node.children != null){
                Collections.reverse(node.children);
                for(Node n: node.children)
                    q.addFirst(n);
            }
        }
        
        // System.out.println(q);
        
        return ans;
    }
}