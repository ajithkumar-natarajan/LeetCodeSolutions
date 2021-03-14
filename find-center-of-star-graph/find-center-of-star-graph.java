class Solution {
    public int findCenter(int[][] edges) {
        
        // Set<Integer> set = new HashSet<>();
//         boolean flag = false;
        
        
//         for(int[] i: edges){
//             if(set.size() == 0){
//                 set.add(i[0]);
//                 set.add(i[1]);
//             }
//             else{
//                 if(set.contains(i[0]))
//                     return i[0];
//                 return i[1];
//             }
//         }
        
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
                
        return edges[0][1];
    }
}