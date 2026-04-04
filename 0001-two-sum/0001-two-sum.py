class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}

        for idx, n in enumerate(nums):
            if (target-n) in d:
                return [idx, d.get(target-n)]
            else:
                d[n] = idx
        
        return