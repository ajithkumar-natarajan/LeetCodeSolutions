class Solution:
    def bitwiseComplement(self, n: int) -> int:
        s = str(bin(n)[2:])
        l = []

        for i in range(len(s)):
            if s[i] == '0':
                l.append('1')
            else:
                l.append('0')

        return int(''.join(l), 2)
            