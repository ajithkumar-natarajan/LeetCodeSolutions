class Solution {

    public int numIslands(char[][] grid) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[0].length; ++j){
                if(grid[i][j] == '1' && !set.contains(i+","+j)){
                    DFSMarking(grid, i, j, set);
                    ++ans;
                }
            }
        }
        
        return ans;
    }

    private char[][] DFSMarking(char[][] grid, int i, int j, Set<String> set) {
        if(set.contains(i+","+j) || i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == '0')
            return grid;
        
        set.add(i+","+j);
        
        DFSMarking(grid, i-1, j, set);
        DFSMarking(grid, i, j-1, set);
        DFSMarking(grid, i+1, j, set);
        DFSMarking(grid, i, j+1, set);
    
        return grid;
    }
}