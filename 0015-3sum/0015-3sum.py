class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        result = []
        nums.sort()

        for i in range(len(nums)):
            j = i+1
            k = len(nums)-1

            if i > 0 and nums[i] == nums[i-1]:
                continue

            while j < k:
                if nums[j]+nums[k] == -nums[i]:
                    result.append([nums[i], nums[j], nums[k]])
                    while nums[k] == nums[k-1] and k > -1:
                        k -= 1
                if nums[j]+nums[k] < -nums[i]:
                    j += 1
                else:
                    k -= 1
              
        return result