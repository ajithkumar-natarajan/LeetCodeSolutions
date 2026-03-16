class Solution:
    def countCommas(self, n: int) -> int:
        if n < 1000:
            return 0

        ans = 0

        while n >= 1000:
            if n >= 10**15:
                ans += 5*(n - (10**15)+1)
                n = (10**15)-1
                
            if n >= 10**12:
                ans += 4*(n - (10**12)+1)
                n = (10**12)-1
                
            elif n >= 10**9:
                ans += 3*(n - (10**9)+1)
                n = (10**9)-1
            
            elif n >= 10**6:
                ans += 2*(n - (10**6)+1)
                n = (10**6)-1
            
            else:
                ans += n - 999
                break

        return ans