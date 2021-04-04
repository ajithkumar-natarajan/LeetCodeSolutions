class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> q = new PriorityQueue<double[]>(new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                if((double)(a[2]-b[2]) < 0)
                    return -1;
                else if((double)(a[2]-b[2]) > 0)
                    return 1;
                return 0;
            }
        });
        int[][] ans = new int[k][2];
        
        for(int[] p: points){
            q.offer(calculateDistance(p));
        }
        
        int i=0;
        
        while(!q.isEmpty() && k-->0){
            ans[i] = new int[]{(int)q.peek()[0], (int)q.poll()[1]};
            ++i;
        }
        
        return ans;
    }
    
    double[] calculateDistance(int[] p){
        double d = Math.sqrt(Math.pow(p[0], 2)+Math.pow(p[1], 2));
        // System.out.println(Arrays.toString(p));
        // System.out.println(d);
        
        return new double[]{p[0], p[1], d};
    }
}