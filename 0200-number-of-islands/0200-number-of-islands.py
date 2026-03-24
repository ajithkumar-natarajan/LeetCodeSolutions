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