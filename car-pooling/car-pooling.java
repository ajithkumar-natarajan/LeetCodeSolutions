class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] tripsA = trips.clone();
        int[][] tripsB = trips.clone();
        int[] count = new int[1000];
        
        Arrays.sort(tripsA, new sortA());
        Arrays.sort(tripsB, new sortB());
        
        
        int c = 0;
        
        for(int i= 0, j = 0; i<1000 && j<tripsA.length;){
            while(i<tripsA[j][1]){
                count[i] = c;
                ++i;
            }
            c += tripsA[j][0];
            // System.out.println(c+" "+i);
            ++j;
            if(j<tripsA.length && (tripsA[j][1] == tripsA[j-1][1]))
                continue;
            count[i] = c;
            ++i;
        }
        
        // System.out.println(Arrays.toString(count));
        
        c = 0;
        
        for(int i= 0, j = 0; i<1000 && j<tripsB.length;){
            while(i<tripsB[j][2]){
                count[i] -= c;
                ++i;
            }
            c += tripsB[j][0];
            // System.out.println(c+" "+i);
            ++j;
            if(j<tripsB.length && (tripsB[j][2] == tripsB[j-1][2]))
                continue;
            count[i] -= c;
            // if(j<tripsB.length && (tripsB[j][2] != tripsB[j-1][2]))
                ++i;
        }
        
        // System.out.println(Arrays.toString(count));
        
        for(int i = 0; i<=tripsA[tripsA.length-1][1]; ++i){
            if(count[i] > capacity)
                return false;
        }
        
        return true;
    }
    
    class sortA implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[1]-b[1] == 0)
                return a[2]-b[2];
            return a[1]-b[1];
        }
    }
    
    class sortB implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[2]-b[2] == 0)
                return a[1]-b[1];
            return a[2]-b[2];
        }
    }
}

// [[2,1,5],[3,3,7]]
// 4
// [[2,1,5],[3,3,7]]
// 5
// [[2,1,5],[3,5,7]]
// 3
// [[2,1,5]]
// 4
// [[8,2,3],[4,1,3],[1,3,6],[8,4,6],[4,4,8]]
// 12
// [[9,3,4],[9,1,7],[4,2,4],[7,4,5]]
// 23
// [[3,2,8],[4,4,6],[10,8,9]]
// 11