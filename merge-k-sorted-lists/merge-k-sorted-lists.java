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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        
        for(ListNode node: lists){
            // System.out.println(node.val);
            while(node != null){
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        // System.out.println(list);
        
        ListNode ans = new ListNode();
        ListNode ret = ans;
        for(int i: list){
            ans.next = new ListNode(i);
            ans = ans.next;
            // ans.val = i;
        }
        
        return ret.next;
    }
}