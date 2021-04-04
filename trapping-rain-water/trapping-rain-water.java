class Solution {
    public int trap(int[] height) {
        int length = height.length;
        
        if(length == 0)
            return 0;
        
        int[] left = new int[length];
        int[] right = new int[length];
        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        int ans = 0;
        
        for(int i=0; i<length; ++i){
            l = Math.max(l, height[i]);
            left[i] = l;
            
            r = Math.max(r, height[length-i-1]);
            right[length-i-1] = r;
        }
        
        for(int i=0; i<length; ++i){
            ans += Math.abs(Math.min(left[i], right[i]) - height[i]);
        }
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        
        return ans;
    }
}