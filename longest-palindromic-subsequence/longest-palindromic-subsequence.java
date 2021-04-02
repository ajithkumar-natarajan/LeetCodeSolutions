class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] mat = new int[s.length()+2][s.length()+1];
        int max = 1;
        
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
                if(s.charAt(i-1) == s.charAt(j-1)){
                    mat[i][j] = mat[i+1][j-1]+2;
                    max = Math.max(max, mat[i][j]);
                }
                else
                    mat[i][j] = Math.max(mat[i+1][j], mat[i][j-1]);
            }
        }
        
        // for(int[] i: mat)
        //     System.out.println(Arrays.toString(i));
        
        return max;
    }
}