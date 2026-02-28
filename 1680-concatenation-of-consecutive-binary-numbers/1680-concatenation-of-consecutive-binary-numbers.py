class Solution:
    def concatenatedBinary(self, n: int) -> int:
        modulo = (10**9)+7
        concat = []

        for x in range(1, n+1):
            concat.append(bin(x)[2:])
        
        b = ''.join(concat)
        i = int(b, 2)
        
        return int(i%modulo)