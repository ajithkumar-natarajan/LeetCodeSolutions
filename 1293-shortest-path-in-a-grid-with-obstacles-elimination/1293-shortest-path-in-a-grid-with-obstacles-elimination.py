class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        rows = len(grid)
        cols = len(grid[0])

        queue = deque([(0, 0, 0, k)])
        visited = set((0, 0, k))
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        while queue:
            curr_x, curr_y, steps, rk = queue.popleft()
            
            if curr_x == rows-1 and curr_y == cols-1:
                return steps
            
            for direction in directions:
                new_x, new_y = curr_x + direction[0], curr_y + direction[1]

                if 0 <= new_x < rows and 0 <= new_y <cols and (new_x, new_y, rk) not in visited:
                    if grid[new_x][new_y] == 1 and rk > 0:
                        queue.append((new_x, new_y, steps+1, rk-1))
                        visited.add((new_x, new_y, rk))
                    elif grid[new_x][new_y] == 0:
                        queue.append((new_x, new_y, steps+1, rk))
                        visited.add((new_x, new_y, rk))

        return -1
