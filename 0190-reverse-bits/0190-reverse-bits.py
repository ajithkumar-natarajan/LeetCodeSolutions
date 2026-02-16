class Solution:
    def reverseBits(self, n: int) -> int:
        given = ''.join(['0']*(32-len(str(bin(n))[2:])))+str(bin(n)[2:])
        return int(given[::-1], base=2)