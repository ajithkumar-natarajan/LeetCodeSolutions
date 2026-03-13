class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        current_max = 0
        buy = prices[0]

        for i in range(1, len(prices)):
            if prices[i] < buy:
                buy = prices[i]
            else:
                current_max = max(current_max, prices[i]-buy)

        return current_max

        