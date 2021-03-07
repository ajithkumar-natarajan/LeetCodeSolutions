class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        int ans = 0;
        
        for(String w: words)
            set.add(w);
        
        for(String w: words){
            for(int i=1; i<w.length(); ++i){
                set.remove(w.substring(i));
            }
        }
        
        for(String w: set){
            ans += w.length();
            ++ans;
        }
        
        return ans;
    }
}