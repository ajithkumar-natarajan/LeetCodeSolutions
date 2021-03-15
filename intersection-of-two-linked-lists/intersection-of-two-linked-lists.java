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
        // ListNode ans = null;
        ListNode startA = headA;
        ListNode startB = headB;
        
        while(!(headA == null && headB == null)){
            // System.out.println(headA);
            // System.out.println(headB);
            if(headA == null)
                headA = startB;
            else if(headB == null)
                headB = startA;
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            
        }
        
        return headA;
    }
}