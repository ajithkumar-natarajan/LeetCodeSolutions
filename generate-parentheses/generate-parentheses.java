class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        // if(n>1)
            set = generate(n, set);
        List<String> ans = new ArrayList<>(set);
        
        return ans;
    }
    
    Set<String> generate(int n, Set<String> set){
        if(n == 1)
            return set;
        
        Set<String> set2 = new HashSet<>();
        for(String s: set){
            StringBuilder sb = new StringBuilder(s);
            for(int i=1; i<=s.length(); ++i){
                String str = sb.substring(0, i)+"()"+sb.substring(i);
                set2.add(str);
            }
        }
        
        set = set2;
        
        // System.out.println(set+" "+n);
        
        return generate(n-1, set);
    }
}