class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        s = [0]
        m = {0:1, 1:0}

        for i in range(1, n+1):
            inverted = list(map(lambda x: m[x], s))
            inverted.reverse()
            s.append(1)
            s.extend(inverted)

        return str(s[k-1])