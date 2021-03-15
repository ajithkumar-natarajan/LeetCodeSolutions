/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null)
            return head;
        
//         int length = 0;
//         ListNode node = head;
//         ListNode firstNode = head;
        
//         while(node != null){
//             ++length;
//             node = node.next;
//         }
        
//         node = head;
        
//         System.out.println(length);
        
//         for(int i=0; i<=length-k+1; ++i)
//         {
//             if(i+1 == k){
//                 firstNode = node;
//                 System.out.println(firstNode.val);
//             }
//             if(i+k == length){
//                 if(firstNode.val == node.val)
//                     return head;
                
//                 firstNode.val ^= node.val;
//                 node.val ^= firstNode.val;
//                 firstNode.val ^= node.val;
                
//             }
//             node = node.next;
//         }
        
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        
        int v1 = list.get(k-1);
        int v2 = list.get(list.size()-k);
        
        list.set(k-1, v2);
        list.set(list.size()-k, v1);
        
        node = head;
        
        // System.out.println(list);
        
        for(int i=0; i<list.size(); ++i){
            node.val = list.get(i);
            node = node.next;
        }
        
        return head;
    }
}