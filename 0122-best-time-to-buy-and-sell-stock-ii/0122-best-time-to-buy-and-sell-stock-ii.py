class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        price = prices[0]

        for p in prices[1:]:
            if p > price:
                profit += (p-price)
            price = p
        
        return profit