class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_volume = float('-inf')

        left, right = 0, len(height)-1

        while left < right:
            current_volume = min(height[left], height[right]) * (right - left)

            max_volume = max(current_volume, max_volume)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_volume