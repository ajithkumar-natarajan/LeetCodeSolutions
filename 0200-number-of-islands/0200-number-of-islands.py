class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        visited = set()

        def exploreNeighbors(location):
            for x, y in directions:
                n_x, n_y = location[0]+x, location[1]+y

                if 0 <= n_x < len(grid) and 0 <= n_y < len(grid[0]) and grid[n_x][n_y] == '1' and (n_x, n_y) not in visited:
                    grid[n_x][n_y] = '0'
                    visited.add((n_x, n_y))
                    exploreNeighbors((n_x, n_y))
            return

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    visited.add((i, j))
                    exploreNeighbors((i, j))
                    answer += 1

        return answer

    #     count = 0
    #     m = len(grid)
    #     n = len(grid[0])

    #     for r in range(m):
    #         for c in range(n):
    #             if grid[r][c] == '1':
    #                 self.cover(grid, r, c)
    #                 count += 1

    #     return count

    # def cover(self, grid, r, c):
    #     queue = []
    #     queue.append((r, c))
    #     grid[r][c] = '0'

    #     while queue:
    #         r, c = queue.pop(0)

    #         if (r-1) >= 0 and grid[r-1][c] == '1':
    #             queue.append((r-1, c))
    #             grid[r-1][c] = '0'
    #         if (r+1) < len(grid) and grid[r+1][c] == '1':
    #             queue.append((r+1, c))
    #             grid[r+1][c] = '0'
    #         if (c-1) >= 0 and grid[r][c-1] == '1':
    #             queue.append((r, c-1))
    #             grid[r][c-1] = '0'
    #         if (c+1) < len(grid[0]) and grid[r][c+1] == '1':
    #             queue.append((r, c+1))
    #             grid[r][c+1] = '0'
        
    #     return grid