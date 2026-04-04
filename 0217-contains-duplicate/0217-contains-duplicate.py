class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s = set(nums)

        return not len(s) == len(nums)