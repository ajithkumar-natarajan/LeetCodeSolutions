class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_volume = float('-inf')
        l, r = 0, len(height)-1

        while l < r:
            max_volume = max(max_volume, (r-l)*min(height[l], height[r]))

            if height[r] < height[l]:
                r -= 1
            else:
                l += 1
        return max_volume