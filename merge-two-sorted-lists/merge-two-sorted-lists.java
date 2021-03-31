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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            if(l2 == null)
                return null;
            return l2;
        }
        if(l2 == null)
            return l1;
        
        ListNode temp = l2;
        ListNode head = l1;
        
        if(l1.val < l2.val){
            // temp = l2.next;
            // l2.next = l1.next;
            // l1.next = l2;
            // l1 = l1.next;
            if(l1.next != null && l1.next.val < l2.val){
                l1 = l1.next;
            }
        }
        else{
            temp = l2.next;
            l2.next = l1;
            head = l2;
            l1 = l2;
        }
        
        while(l1.next != null && temp != null){
            if(l1.next.val < temp.val){
                l1 = l1.next;
            }
            else{
                ListNode node = temp.next;
                temp.next = l1.next;
                l1.next = temp;
                l1 = l1.next;
                temp = node;
            }
        }
        
        if(l1.next == null)
            l1.next = temp;
        
        return head;
    }
}