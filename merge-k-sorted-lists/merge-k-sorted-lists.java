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
        ListNode ans = new ListNode(0);
        ListNode ret = ans;
        
        if(lists.length == 0)
            return ans.next;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val > o2.val)
                    return 1;
                return 0;
            }
        });
        
        for(ListNode l: lists){
            if(l != null)
                q.offer(l);
        }
        
        // for(ListNode l: q)
        //     System.out.println(l.val);
        
        while(!q.isEmpty()){
            ListNode node = q.poll();
            ans.next = new ListNode(node.val);
            ans = ans.next;
            
            if(node.next != null)
                q.offer(node.next);
        }
        
        
        return ret.next;
        
        
        
        
        // List<Integer> list = new ArrayList<>();
        
        // for(ListNode node: lists){
        //     System.out.println(node.val);
        //     while(node != null){
        //         list.add(node.val);
        //         node = node.next;
        //     }
        // }
//         Collections.sort(list);
        // System.out.println(list);
        
//         ListNode ans = new ListNode();
//         ListNode ret = ans;
//         for(int i: list){
//             ans.next = new ListNode(i);
//             ans = ans.next;
//             // ans.val = i;
//         }
        
        // return lists[0];
        // return ret.next;
    }
}