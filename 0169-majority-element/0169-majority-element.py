class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # count_map = dict()
        # length = len(nums)

        # for n in nums:
        #     count = count_map.get(n, 0)
        #     count += 1
        #     count_map[n] = count

        #     if count > length//2:
        #         return n

        # return 0

        count = 1
        res = nums[0]

        for n in nums[1:]:
            if n == res:
                count += 1
            else:
                count -= 1
            
            if count < 0:
                count = 0
                
            if count == 0:
                res = n
                count += 1

        return res