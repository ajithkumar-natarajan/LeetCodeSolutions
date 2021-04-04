class Solution {
    public int firstUniqChar(String s) {
        // TreeMap<Integer, Character> map1 = new TreeMap<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        // Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        // int ans = -1;
        
        for(int i=0; i<ch.length; ++i){
            // int pos = map2.getOrDefault(ch[i], 0);
            // if(pos == 0){
            //     map2.put(ch[i], i+1);
            //     map1.put(i+1, ch[i]);
            // }
            // else{
            //     map2.remove(map1.get(pos));
            //     map1.remove(pos);
            // }
            List list = map.getOrDefault(ch[i], new ArrayList<>());
            list.add(i);
            map.put(ch[i], list);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(Map.Entry<Character, List<Integer>> entry: map.entrySet()){
            if(entry.getValue().size() > 1)
                continue;
            ans = Math.min(ans, entry.getValue().get(0));
        }
        
        // if(!map1.isEmpty())
        //     return map1.firstKey()-1;
        // else
        //     return -1;
        
        if(ans == Integer.MAX_VALUE)
            return -1;
        
        return ans;
    
    }
}