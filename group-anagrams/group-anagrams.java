class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Set<Character> set = new TreeSet<>();
        Map<List<Integer>, List<String>> map = new HashMap<>();
        
        for(String s: strs){
            // int[] i = new int[26];
            List<Integer> i = new ArrayList<>(26);
            for(int z=0; z<26; ++z)
                i.add(0);
            for(char c: s.toCharArray()){
                int key = (int)c-(int)'a';
                int count = i.get(key);
                i.set(key, ++count);
                // set.add(c);
            }
            List l = map.getOrDefault(i, new ArrayList<>());
            l.add(s);
            map.put(i, l);
        }
        
        // System.out.println(map);
        // System.out.println(set);
        
        return new ArrayList<>(map.values());
    }
}