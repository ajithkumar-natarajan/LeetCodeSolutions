class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        
        for(int i=0; i<9; ++i){
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            for(int j=0; j<9; ++j){
                // if(board[i][j] == '.')
                //     continue;
                
                if(board[i][j] != '.' && !set1.contains(board[i][j])){
                    // System.out.println(board[i][j]);
                    set1.add(board[i][j]);
                }
                else if(board[i][j] != '.')
                    return false;
                
                if(board[j][i] != '.' && !set2.contains(board[j][i])){
                    // System.out.println(board[j][i]);
                    set2.add(board[j][i]);
                }
                else if(board[j][i] != '.')
                    return false;
            }
            // System.out.println(set1);
            // System.out.println(set2);
        }
        
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        for(int i=0; i < 9; ++i){
            boolean flag = true;
            for(int j=0; j<3; ++j){
                // for(int k=i; k<k+3; ++k){
                //     for(int l=j; l<l+3; ++l){
    //                 int k = i+3;
    //                 int l = j+3;
    //                 for(; i<k; ++i){
    //                     for(j=0; j<l; ++j){

                            // if(board[i][j] != '.' && !set1.contains(board[i][j])){
    //                             // System.out.println(board[i][j]);
    //                             set1.add(board[i][j]);
    //                         }
    //                         else if(board[i][j] != '.')
    //                             return false;
    //                     }
    //                 }
                if(i%3 == 0 && flag){
                    set1 = new HashSet<>();
                    set2 = new HashSet<>();
                    set3 = new HashSet<>();
                }
                if(board[i][j] != '.' && !set1.contains(board[i][j]))
                    set1.add(board[i][j]);
                else if(board[i][j] != '.')
                    return false;
                
                if(board[i][j+3] != '.' && !set2.contains(board[i][j+3]))
                    set2.add(board[i][j+3]);
                else if(board[i][j+3] != '.')
                    return false;
                
                if(board[i][j+6] != '.' && !set3.contains(board[i][j+6]))
                    set3.add(board[i][j+6]);
                else if(board[i][j+6] != '.')
                    return false;
                
                flag = false;
                
                // System.out.println(i+" "+j+" "+set1+ " "+ flag);
                // System.out.println(i+" "+j+" "+set2+ " "+ flag);
                // System.out.println(i+" "+j+" "+set3+ " "+ flag);
            }
            // System.out.println(i+" "+set1);
            // System.out.println(i+" "+set2);
            // System.out.println(i+" "+set3);
        }
        
        
        return true;
    }
}