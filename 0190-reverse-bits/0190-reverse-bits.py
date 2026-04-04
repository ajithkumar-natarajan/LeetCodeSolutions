class Solution:
    def reverseBits(self, n: int) -> int:
        # given = ''.join(['0']*(32-len(str(bin(n))[2:])))+str(bin(n)[2:])
        # return int(given[::-1], base=2)

        rev = ['0']*32
        b = str(bin(n))[2::][::-1]
        
        for idx, c in enumerate(b):
            rev[idx] = c

        return int(''.join(rev), 2)