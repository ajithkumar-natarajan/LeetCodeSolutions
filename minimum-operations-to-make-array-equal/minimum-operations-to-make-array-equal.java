class Solution {
    public int minOperations(int n) {
        int ans = 0;
        
        for(int i=n/2; i<n; ++i){
            int val = (2 * i) + 1;
            if(val > n)
                ans += val-n;
        }
        
        return ans;
        
    }
}

// class Solution {
//     public int minOperations(int n) {
//         int ans = 0;
//         int m = n;
        
//         if(n%2 == 0){
//             // int mid = 2*(n/2)+1;
//             while(--m >= n/2){
//                 ans += (2*m+1-n);
//             }
//         }
//         else{
//             int last = 2*(n-1)+1;
//             while(last > n){
//                 // System.out.println(last);
//                 ans += last-n;
//                 last -= 2;
//             }
//         }
        
//         return ans;
//     }
// }