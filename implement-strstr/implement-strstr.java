class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        
        for(int i=0, j=0; i<haystack.length(); ++i){
            if(needle.charAt(j) == haystack.charAt(i)){
                int k = i;
                while(j<needle.length() && k<haystack.length() && needle.charAt(j) == haystack.charAt(k)){
                    ++k;
                    ++j;
                }
                // System.out.println(i+" "+j+" "+k);
                if(j == needle.length())
                    return i;
                j = 0;
            }
        }
        
        return -1;
    }
}