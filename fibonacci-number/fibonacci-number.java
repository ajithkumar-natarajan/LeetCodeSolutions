class Solution {
    public int fib(int n) {
        int a = 0, b = 1;
        
        if(n == 0)
            return a;
        if(n == 1)
            return b;
        
        int c = 1;
        int ans = 0;
        
        while(c++ < n){
            ans = b+a;
            a = b;
            b = ans;
        }
        
        return ans;
    }
}