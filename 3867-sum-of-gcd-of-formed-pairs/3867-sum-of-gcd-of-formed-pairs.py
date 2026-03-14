class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        n = len(nums)
        
        prefixGcd = []
        current_max = 0
        
        for x in nums:
            current_max = max(current_max, x)
            prefixGcd.append(math.gcd(x, current_max))
            
        prefixGcd.sort()
        
        total_sum = 0
        left = 0
        right = n - 1
        
        while left < right:
            pair_gcd = math.gcd(prefixGcd[left], prefixGcd[right])
            total_sum += pair_gcd
            left += 1
            right -= 1
            
        return total_sum