class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        return fill(image, sr, sc, image[sr][sc], newColor);
    }
    
    private int[][] fill(int[][] image, int sr, int sc, int oldColor, int newColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return image;
        
        if(image[sr][sc] == oldColor)
            image[sr][sc] = newColor;
        else
            return image;
        
        System.out.println(sr+" "+sc);
        
        image = fill(image, sr-1, sc, oldColor, newColor);
        image = fill(image, sr, sc-1, oldColor, newColor);
        image = fill(image, sr+1, sc, oldColor, newColor);
        image = fill(image, sr, sc+1, oldColor, newColor);
    
        return image;
    }
}