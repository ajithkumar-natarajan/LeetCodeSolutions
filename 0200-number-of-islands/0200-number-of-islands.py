class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        
        def clear(x, y):
            queue = deque([(x, y)])

            while queue:
                x, y = queue.popleft()
                for dx, dy in directions:
                    nx, ny = x+dx, y+dy
                    if 0<=nx<len(grid) and 0<=ny<len(grid[0]) and grid[nx][ny] == '1':
                        grid[nx][ny] = '0'
                        queue.append((nx, ny))
        

        for x in range(len(grid)):
            for y in range(len(grid[0])):
                if grid[x][y] == '1':
                    answer += 1
                    clear(x, y)

        return answer