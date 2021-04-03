class Solution {
    public int maxArea(int[] height) {
        
        int ans = 0;
        
        for(int i=0, j=height.length-1; i<j;){
            ans = Math.max(ans, Math.min(height[i], height[j])*(j-i));
            
            if(height[i]<height[j])
                ++i;
            else
                --j;
        }
        
        return ans;
//         int[] diff = new int[height.length];
//         int ans = Integer.MIN_VALUE;
        
//         for(int i=0; i<height.length; ++i){
//             for(int j=i+1; j<height.length; ++j){
//                 diff[i] = Math.max(diff[i], (Math.min(height[i], height[j])*(j-i)));
//                 // System.out.println(Math.min(height[i], height[j])*(j-i));
//                 // System.out.println(height[i]+" "+height[j]+" "+(j-i));
//                 if(diff[i] > ans)
//                     ans = diff[i];
//             }
//         }
        
//         // for(int i: diff)
//         //     ans = Math.max(i, ans);
        
//         return ans;
    }
}