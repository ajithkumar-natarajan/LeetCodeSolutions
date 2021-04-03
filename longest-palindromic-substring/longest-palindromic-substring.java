class Solution {
    public String longestPalindrome(String s) {
//         int max = 1;
//         String ans = String.valueOf(s.charAt(0));
        
//         for(int i=0; i<s.length(); ++i){
//             for(int j=i; j<s.length(); ++j){
//                 String str = s.substring(i, j+1);
//                 if(str.equals(new StringBuilder(str).reverse().toString())){
//                     if(str.length() > max){
//                         max = str.length();
//                         ans = str;
//                     }
//                 }
//             }
//         }
//         
        // return ans;
        
        int[][] mat = new int[s.length()+2][s.length()+1];
        int start = 0;
        int end = 1;
        
        for(int k=0, l=1; k<s.length(); ++k){
            int i = l;
            int j = l;
            j += k;
            // System.out.println(i+" "+j);
            
            for(; j<=s.length() && i<=s.length(); ++j, ++i){
                if(i == j){
                    mat[i][j] = 1;
                    continue;
                }
                if(j-i == 1 && s.charAt(i-1) == s.charAt(j-1)){
                    mat[i][j] = 1;
                    start = i-1;
                    end = j;
                    // System.out.println(start+" "+end+" "+s.charAt(i-1)+" "+s.charAt(j-1));
                    continue;
                }
                if(s.charAt(i-1) == s.charAt(j-1) && mat[i+1][j-1] == 1){
                    mat[i][j] = 1;
                    start = i-1;
                    end = j;
                    // System.out.println(start+" "+end+" "+s.charAt(i-1)+" "+s.charAt(j-1));
                }
            }
        }
        
        return s.substring(start, end);
        
        // for(int[] i: mat)
        //     System.out.println(Arrays.toString(i));
        
    }
}