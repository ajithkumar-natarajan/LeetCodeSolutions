class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        // [1,2,2] -> [1,0][1,4][-1,2][3,2]
        // [1,1],[2,2],[3,3],[4,4],[5,5]
        // [1,1,2] -> [-1,1][3,1][1,-1][1,3]
        // [[1,3],[3,3],[5,3],[2,2]]
        int[] ans = new int[queries.length];
        
        for(int i=0; i<queries.length; ++i){
            int[] query = queries[i];
            int count = 0;
            for(int[] point: points){
                if(Math.pow(point[0]-query[0], 2)+Math.pow(point[1]-query[1], 2) <= query[2]*query[2])
                    ++count;
                // if(point[0]>=query[0]-query[2] && point[0]<=query[0]+query[2]){
                //     if(point[1]>=query[1]-query[2] && point[1]<=query[1]+query[2]){
                //         ++count;
                //         System.out.println(Arrays.toString(point));
                //         System.out.println("1 "+Arrays.toString(query)+" "+count);
                //     }
                // }
                // else if(point[1]>=query[1]-query[2] && point[1]<=query[1]+query[2]){
                //     ++count;
                //     System.out.println(Arrays.toString(point));
                //     System.out.println("2 "+Arrays.toString(query)+" "+count);
                // }
            }
            ans[i] = count;
        }
        
        return ans;
    }
}