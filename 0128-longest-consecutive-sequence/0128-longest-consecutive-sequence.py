class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # if not nums:
        #     return 0
        # ma = float('-inf')
        # mi = float('inf')
        # for n in nums:
        #     ma = max(ma, n)
        #     mi = min(mi, n)
        # array = [0]*(abs(mi)+ma+1)

        # for n in nums:
        #     array[abs(mi)+n] += 1
        
        # result = 0
        # count = 0
        # for n in array:
        #     if n > 0:
        #         count += 1
        #     else:
        #         result = max(count, result)
        #         count = 0
        # result = max(count, result)

        # return result

        result = 0
        nums = set(nums)

        for n in nums:
            if (n-1) not in nums:
                start = 1
                while (start+n) in nums:
                    start += 1
                result = max(result, start)
        return result