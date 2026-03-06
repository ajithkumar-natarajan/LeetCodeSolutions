class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        current_max = 0 
        lowest_price = prices[0]

        for i in range(len(prices)):
            lowest_price = min(prices[i], lowest_price)
            current_max = max(prices[i]-lowest_price, current_max)

        return current_max