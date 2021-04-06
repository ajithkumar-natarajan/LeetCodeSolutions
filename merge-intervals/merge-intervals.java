class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        
        // PriorityQueue<int[]> q = new PriorityQueue<>(new sort());
        List<int[]> sorted = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        
        
        for(int[] i: intervals)
            // q.offer(i);
            sorted.add(i);
        
        Collections.sort(sorted, new sort());
        
        // while(!q.isEmpty()){
        //     sorted.add(q.poll());
        // }
        
        for(int i=0; i<sorted.size(); ++i){
            int[] a = sorted.get(i);
            int max = a[1];
            
            while(i<sorted.size()-1 && max >= sorted.get(i+1)[0]){
                max = Math.max(max, sorted.get(i+1)[1]);
                ++i;
            }
            
            a[1] = max;
            
            ans.add(a);
        }
        
        return ans.toArray(new int[0][0]);
    }
    
    class sort implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0] < b[0])
                return -1;
            if(a[0] > b[0])
                return 1;
            return a[1]-b[1];
        }
    }
}