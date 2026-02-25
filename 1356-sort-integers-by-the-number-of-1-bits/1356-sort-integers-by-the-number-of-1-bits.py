class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        arr.sort()
        b = []
        ans = []

        for x in arr:
            b.append(bin(x)[2:])
        
        b.sort(key=lambda item: item.count('1'))
        
        for x in b:
            ans.append(int(x, 2))

        return ans