class Solution {
    public int missingNumber(int[] nums) {
        int a = 0;
        
        for(int i=0; i<=nums.length; ++i)
            a ^= i;
        
        // System.out.println(a);
        
        for(int i: nums)
            a ^= i;
        
        // System.out.println(a);
        
        return a;
    }
}