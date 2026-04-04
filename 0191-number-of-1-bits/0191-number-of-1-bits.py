class Solution:
    def hammingWeight(self, n: int) -> int:
        return (Counter(str(bin(n))[2:])['1'])