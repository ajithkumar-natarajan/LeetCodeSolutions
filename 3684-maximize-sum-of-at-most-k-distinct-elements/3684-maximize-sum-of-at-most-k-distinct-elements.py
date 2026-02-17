class Solution:
    def maxKDistinct(self, nums: List[int], k: int) -> List[int]:
        nums.sort()
        res = []
        last = nums[-1]
        res.append(last)
        c = 1

        for n in nums[::-1]:
            if c == k:
                break
            if n < last:
                res.append(n)
                last = n
                c += 1

        return res