class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Set<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i=0; i<s.length(); ++i){
            char curr = s.charAt(i);
            
            if(map.containsKey(curr)){
                if(t.charAt(i) == map.get(curr))
                    continue;
                else
                    return false;
            }
            char mapped = t.charAt(i);
            
            if(set.contains(mapped))
                return false;
            
            map.put(curr, mapped);
            set.add(mapped);
        }
        
        return true;
    }
}