class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; ++i){
            int num = target-nums[i];
            // if(num == nums[i])
            //     continue;
            if(map.containsKey(nums[i]))
                return new int[]{i, map.get(nums[i])};
            else
                map.put(num, i);
            // System.out.println(map);
        }
        
        return new int[]{0, 0};
    }
}