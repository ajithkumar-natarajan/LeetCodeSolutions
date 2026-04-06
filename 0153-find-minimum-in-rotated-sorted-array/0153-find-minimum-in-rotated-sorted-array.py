class Solution:
    def findMin(self, nums: List[int]) -> int:
        lowest = float('inf')

        if len(nums) == 1:
            return nums[0]

        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left + right) // 2
            lowest = min(lowest, nums[mid])

            if nums[mid] <= nums[right]:
                right = mid - 1
            else:
                left = mid + 1
        return lowest