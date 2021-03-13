class Solution {
//     Queue<String> q = new LinkedList<>();
    
//     public boolean hasAllCodes(String s, int k) {
//         q.offer("");
//         printBinary(k, q, 1);
//         // System.out.println(q);
        
//         for(String st: q){
//             if(!s.contains(st))
//                 return false;
//         }
        
//         return true;
//     }
    
//     void printBinary(int k, Queue<String> q, int size){
//         if(q.peek().length() == k)
//             return;
        
//         for(int i=0; i<size; ++i){
//             String s = q.poll();
            
//             q.offer(s+"0");
//             q.offer(s+"1");
//         }
        
//         printBinary(k, q, q.size());
//     }
    
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i=0; i+k <= s.length(); ++i){
            set.add(s.substring(i, i+k));
        }
        // System.out.println(set);
        
        return set.size() == Math.pow(2, k);
    }
}