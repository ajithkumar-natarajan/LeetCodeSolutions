class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_water = 0

        left, right = 0, len(height)-1

        while left < right:
            total_water = min(height[left], height[right])*(right-left)

            max_water = max(total_water, max_water)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return max_water