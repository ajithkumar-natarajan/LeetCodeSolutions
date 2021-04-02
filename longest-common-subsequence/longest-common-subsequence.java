class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0)
            return 0;
        
        int[][] mat = new int[text1.length()+1][text2.length()+1];
        int max = 0;
        
        for(int i=1; i<= text1.length(); ++i){
            for(int j=1; j<=text2.length(); ++j){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1]+1;
                    max = Math.max(max, mat[i][j]);
                }
                else{
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        
        // for(int[] i: mat)
        //     System.out.println(Arrays.toString(i));
        
        return max;
    }
}