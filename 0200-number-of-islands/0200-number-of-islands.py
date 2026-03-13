class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        m = len(grid)
        n = len(grid[0])

        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    self.cover(grid, r, c)
                    count += 1

        return count

    def cover(self, grid, r, c):
        queue = []
        queue.append((r, c))
        grid[r][c] = '0'

        while queue:
            r, c = queue.pop(0)

            if (r-1) >= 0 and grid[r-1][c] == '1':
                queue.append((r-1, c))
                grid[r-1][c] = '0'
            if (r+1) < len(grid) and grid[r+1][c] == '1':
                queue.append((r+1, c))
                grid[r+1][c] = '0'
            if (c-1) >= 0 and grid[r][c-1] == '1':
                queue.append((r, c-1))
                grid[r][c-1] = '0'
            if (c+1) < len(grid[0]) and grid[r][c+1] == '1':
                queue.append((r, c+1))
                grid[r][c+1] = '0'
        
        return grid