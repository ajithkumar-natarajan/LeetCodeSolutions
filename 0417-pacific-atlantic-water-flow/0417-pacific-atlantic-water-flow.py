class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        visited = set()
        m = len(heights)
        n = len(heights[0])
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        p_queue = deque()
        a_queue = deque()
        
        for i in range(m):
            p_queue.append((i, 0))
            a_queue.append((i, n-1))
        for i in range(n):
            p_queue.append((0, i))
            a_queue.append((m-1, i))

        def bfs(q):
            visited = set()

            while q:
                x, y = q.popleft()
                visited.add((x, y))
                for dx, dy in directions:
                    nx, ny = x+dx, y+dy
                    if 0<=nx<m and 0<=ny<n and (nx, ny) not in visited and heights[nx][ny]>=heights[x][y]:
                        q.append((nx, ny))
            return visited
        
        p = bfs(p_queue)
        a = bfs(a_queue)

        return list(p.intersection(a))