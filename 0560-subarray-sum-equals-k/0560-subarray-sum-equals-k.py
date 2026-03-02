class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        ans = 0
        prefix = {0:1}
        total = 0
        for x in nums:
            total += x

            if total-k in prefix:
                ans += prefix.get(total-k)
                
            prefix[total] = prefix.get(total, 0)+1

        return ans