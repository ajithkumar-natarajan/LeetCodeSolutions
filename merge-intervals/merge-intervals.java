class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        PriorityQueue<int[]> q = new PriorityQueue<>(new sort());
        // PriorityQueue<Integer> q = new PriorityQueue<>();
        List<int[]> sorted = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        
        
        for(int[] i: intervals)
            // q.offer(i[0]);
            q.offer(i);
        
        // Iterator<int[]> iter = q.iterator();
        while(!q.isEmpty()){
            // int[] i = q.poll();
            // System.out.println(Arrays.toString(i));
            sorted.add(q.poll());
        }
        // for(int[] i: sorted)
        //     System.out.println(Arrays.toString(i));
        
        for(int i=0; i<sorted.size(); ++i){
            int[] a = sorted.get(i);
            // boolean flag = false;
            int max = a[1];
            // int[] b = sorted.get(i+1);
            
//             if(b[0] <= a[1]){
                
//             }
            while(i<sorted.size()-1 && max >= sorted.get(i+1)[0]){
                max = Math.max(max, sorted.get(i+1)[1]);
                ++i;
                // System.out.println(max);
                // flag = true;
            }
            
            // if(i<sorted.size() && flag){
                a[1] = max;
                // --i;
            // }
            ans.add(a);
            // for(int[] arr: ans)
            //     System.out.print(Arrays.toString(arr));
            // System.out.println();
        }
        
        // Iterator<Integer> iter = q.iterator();
        // while(!q.isEmpty()){
            // int i = iter.next();
            // System.out.println(q.poll());
        // }
        
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