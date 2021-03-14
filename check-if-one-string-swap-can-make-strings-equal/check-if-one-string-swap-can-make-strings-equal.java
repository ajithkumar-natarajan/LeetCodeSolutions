class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        int count = 0;
        // List<Character> list = new ArrayList<>();
        // Set<Character> set1 = new HashSet<>();
        // Set<Character> set2 = new HashSet<>();
        int j = 0;
        char[] arr1 = new char[2];
        char[] arr2 = new char[2];
        
        for(int i=0; i<s1.length(); ++i){
            if(s1.charAt(i) != s2.charAt(i)){
                ++count;
                
                if(count == 3)
                    return false;
                
                // set1.add(s1.charAt(i));
                // set2.add(s2.charAt(i));
                arr1[j] = s1.charAt(i);
                arr2[j] = s2.charAt(i);
                ++j;
            }
            // System.out.println(list);
            // System.out.println(count);
            // list.add(s1.charAt(i));
        }
        
        // for(char c: s2.toCharArray()){
        //     if(list.contains(c))
        //         list.remove(c);
        //     else
        //         return false;
        // }
        
        if(count == 0 || count == 2 && (arr1[0] == arr2[1] && arr1[1] == arr2[0]))
            return true;
        
        return false;
    }
}