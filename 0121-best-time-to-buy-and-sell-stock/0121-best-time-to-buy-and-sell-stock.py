class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        answer = 0
        low = float('inf')

        for price in prices:
            low = min(low, price)
            answer = max(answer, price-low)

        return answer