/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        
        Node ans = new Node(0);
        Node dup = ans;
        Node h = head;
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        
        
        while(head != null){
            list1.add(head);
            head = head.next;
        }
        
        head = h;
        
        while(head != null){
            ans.next = new Node(head.val);
            ans = ans.next;
            list2.add(ans);
            head = head.next;
        }
        
        // System.out.println(list1);
        // System.out.println(list2);
        
        ans = dup.next;
        while(h != null){
            if(h.random != null){
                ans.random = list2.get(list1.indexOf(h.random));
            }
            ans = ans.next;
            h = h.next;
        }
        
        return dup.next;
    }
}