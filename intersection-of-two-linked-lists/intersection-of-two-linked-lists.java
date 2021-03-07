/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        ListNode ans = null;
        ListNode tail1 = headA;
        ListNode tail2 = headB;
        
        Set<ListNode> set = new HashSet<>();
        
        while(tail1 != null){
            set.add(tail1);
            tail1 = tail1.next;
        }
        
        while(tail2 != null){
            if(set.contains(tail2))
                return tail2;
            tail2 = tail2.next;
        }
        
        return ans;        
    }
}