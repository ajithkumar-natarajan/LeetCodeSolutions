class Solution:
    def minOperations(self, s: str) -> int:
        parity = ['1' if x % 2 == 0 else '0' for x in range(len(s))]

        ones = 0
        zeros = 0

        for i in range(len(parity)):
            ones += int(parity[i]) ^ int(s[i])
            
        parity = ['0' if x % 2 == 0 else '1' for x in range(len(s))]

        for i in range(len(parity)):
            zeros += int(parity[i]) ^ int(s[i])

        return min(ones, zeros)