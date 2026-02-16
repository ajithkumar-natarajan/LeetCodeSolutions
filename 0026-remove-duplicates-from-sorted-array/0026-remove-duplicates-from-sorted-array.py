class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        last_seen = nums[0]
        count = 1

        for n in nums[1:]:
            if n > last_seen:
                nums[count] = n
                last_seen = n
                count += 1

        return count