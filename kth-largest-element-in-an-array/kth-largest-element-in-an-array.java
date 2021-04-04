class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i: nums){
            q.offer(i);
            
            if(q.size() > k)
                q.poll();
            
            // System.out.println(q);
        }
        
        return q.peek();
            
//         Arrays.sort(nums);
        
//         return nums[nums.length-k];
    }
}