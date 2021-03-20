class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        
        // Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 1;
        int length = 0;
        
        for(int i=0; i<s.length(); ++i){
            if(!map.containsKey(s.charAt(i))){
                ++length;
                map.put(s.charAt(i), i);
            }
            else{
                ans = Math.max(ans, length);
                length = 0;
                // int j = i;
                i = map.get(s.charAt(i));
                // map.remove(s.charAt(i));
                map.clear();
                // --i;
                // map.put(s.charAt(j), j);
            }
            // System.out.println(map+" "+length+" "+ans+" "+i);
        }
        
        return Math.max(ans, length);
    }
}