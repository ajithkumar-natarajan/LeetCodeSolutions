import copy

class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])

        ans = [[0]*n for _ in range(m)]

        k = k%(m*n)

        for r in range(m):
            for c in range(n):
                flat_index = r*n+c

                new_flat_index = (flat_index+k)%(m*n)

                new_r = new_flat_index//n
                new_c = new_flat_index%n

                ans[new_r][new_c] = grid[r][c]

        return ans