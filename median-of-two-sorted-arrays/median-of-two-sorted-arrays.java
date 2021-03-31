class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];
        int i = 0, j = 0, k = 0;
        
        for(; i<nums1.length && j<nums2.length; ++k){
            if(nums1[i] < nums2[j]){
                merged[k] = nums1[i];
                ++i;
            }
            else{
                merged[k] = nums2[j];
                ++j;
            }
        }
        
        while(i < nums1.length){
            merged[k++] = nums1[i++];
        }
        while(j < nums2.length){
            merged[k++] = nums2[j++];
        }
        
        // System.out.println(Arrays.toString(merged));
        
        if(k % 2 == 0){
            return (double)(merged[(k-1)/2]+merged[k/2])/2;
        }
        else
            return (double)merged[k/2];
    }
}