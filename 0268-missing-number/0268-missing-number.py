class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums = set(nums)

        for n in range(len(nums)+1):
            if n not in nums:
                return n