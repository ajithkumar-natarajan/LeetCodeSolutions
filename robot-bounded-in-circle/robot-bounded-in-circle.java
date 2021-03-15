class Solution {
    public boolean isRobotBounded(String instructions) {
//         char dir = 'N';
//         int x = 0, y = 0;
        
//         for(int i=0; i<4; ++i){
//             for(char c: instructions.toCharArray()){
//                 if(c=='G'){
//                     if(dir=='N'){
//                         y += 1;
//                     }
//                     if(dir=='S'){
//                         y -= 1;
//                     }
//                     if(dir=='E'){
//                         x += 1;
//                     }
//                     if(dir=='W'){
//                         x -= 1;
//                     }
//                 }
//                 if(c=='L'){
//                     if(dir=='N'){
//                         // System.out.println("in");
//                         // System.out.println(dir);
//                         dir = 'W';
//                         // System.out.println(dir);
//                     }
//                     else if(dir=='W'){
//                         dir = 'S';
//                     }
//                     else if(dir=='S'){
//                         dir = 'E';
//                     }
//                     else if(dir=='E'){
//                         dir = 'N';
//                     }
//                 }
//                 if(c=='R'){
//                     if(dir=='N'){
//                         dir = 'E';
//                     }
//                     else if(dir=='E'){
//                         dir = 'S';
//                     }
//                     else if(dir=='S'){
//                         dir = 'W';
//                     }
//                     else if(dir=='W'){
//                         dir = 'N';
//                     }
//                 }

//                 System.out.println(dir+" "+x+" "+y);
//             }

//             if(i==1 && dir=='N' && x==0 && y==0)
//             // if(x==0 && y==0)
//                 return true;
            

//         }
//         return false;
        
        int x = 0, y = 0;
        int dir = 0;
        int[][] pos = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        for(char c: instructions.toCharArray()){
            if(c == 'L')
                dir = (dir+1)%4;
            else if(c == 'R')
                dir = (dir+3)%4;
            else{
                x += pos[dir][0];
                y += pos[dir][1];
            }
            
            // System.out.println(x);
            // System.out.println(y);
        }
        
        if(x == 0 && y == 0)
            return true;
        
        
        if(dir == 0 && (x != 0 || y != 0))
            return false;
        
        return true;
    }
}