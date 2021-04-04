class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] ans = new int[k];
        
        for(int i: nums){
            int count = hashmap.getOrDefault(i, 0);
            hashmap.put(i, ++count);
        }
        
        for(Map.Entry<Integer, Integer> entry: hashmap.entrySet())
            q.offer(new int[]{entry.getKey(), entry.getValue()});
        
        for(int i=0; i<k; ++i){
            ans[i] = q.poll()[0];
        }
        
        return ans;
        
//         Map<Integer, Integer> hashmap = new HashMap<>();
//         Map<Integer, List<Integer>> treemap = new TreeMap<>(Collections.reverseOrder());
//         int[] ans = new int[k];
        
//         for(int i: nums){
//             int count = hashmap.getOrDefault(i, 0);
//             hashmap.put(i, ++count);
//         }
        
//         for(Map.Entry<Integer, Integer> entry: hashmap.entrySet()){
//             int i = entry.getKey();
//             int j = entry.getValue();
            
//             // if(treemap.containsKey(j)){
//             //     List<Integer> list = treemap.get()
//             // }
//             List<Integer> list = treemap.getOrDefault(j, new ArrayList<>());
//             list.add(i);
//             treemap.put(j, list);
//         }
        
//         // System.out.println(treemap);
        
//         int i = 0;
//         for(List<Integer> l: treemap.values()){
//             for(int c: l){
//                 ans[i] = c;
//                 ++i;
//                 if(i == k)
//                     break;
//             }
//             if(i == k)
//                     break;
//         }
        
//         return ans;
    }
}