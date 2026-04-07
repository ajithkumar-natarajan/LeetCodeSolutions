class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}

        def solve(coins, amount):
            if amount < 0:
                return -1
            if amount == 0:
                return 0
            if amount in memo:
                return memo[amount]
            least = float('inf')
            total = 0
            for coin in coins:
                resp = solve(coins, amount-coin)
                if resp != -1:
                    least = min(least, resp+1)
                    memo[amount] = least

            return least

        least = solve(coins, amount)

        return least if least != float('inf') else -1