class Solution:
    def binaryGap(self, n: int) -> int:
        s = bin(n)[2:]
        ans = 0
        
        i = -1
        for j, c in enumerate(s):
            if c == '1':
                if i != -1:
                    ans = max(ans, j-i)
                    i = j
                else:
                    i = j
        return ans