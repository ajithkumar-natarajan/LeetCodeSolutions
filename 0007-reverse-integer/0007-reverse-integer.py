class Solution:
    def reverse(self, x: int) -> int:
        ans = 0
        flag = 1
        if x < 0:
            x = abs(x)
            flag *= -1

        while x > 9:
            ans += x % 10
            x //= 10
            ans *= 10
        
        ans += x
        ans *= flag
        
        if 2**31*-1 < ans < 2**31-1:
            return ans
        return 0