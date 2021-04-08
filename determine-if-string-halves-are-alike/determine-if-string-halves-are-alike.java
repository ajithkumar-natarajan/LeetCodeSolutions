class Solution {
    public boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        int length = s.length();
        char[] inp = s.toCharArray();
        Set<Character> set = new HashSet<>();
        
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        
        for(int i=0; i<length; ++i){
            if(i < length/2){
                if(set.contains(inp[i]))
                    ++count1;
            }
            else
                if(set.contains(inp[i]))
                    ++count2;
        }
        
        return count1==count2;
    }
}