class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for(int i=0; i<numbers.length; ++i){
            int n = numbers[i];
            int start = i;
            int end = numbers.length;
            while(start < end){
                int mid = start+ (end-start)/2;
                // System.out.println(end+" "+start+" "+mid);
                if(numbers[mid] < target-n){
                    start = mid+1;
                }
                else if(numbers[mid] > target-n){
                    end = mid;
                }
                else return new int[]{i+1, mid+1};
            }
        }
        
        return new int[]{0,0};
    }
}