class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        if not board:
            return

        m, n = len(board), len(board[0])

        i, j = click

        if board[i][j] == 'M':
            board[i][j] = 'X'
            return board

        visited = set((i, j))
        queue = deque()
        queue.append((i, j))
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]

        while queue:
            i, j = queue.popleft()
            mines = 0
            for direction in directions:
                x, y = direction
                n_r, n_c = i+x, j+y

                if (0 <= n_r < m and 0 <= n_c < n) and board[n_r][n_c] == 'M':
                    mines += 1
                
            if mines > 0:
                board[i][j] = str(mines)
            else:
                board[i][j] = 'B'
                for dx, dy in directions:
                    n_r, n_c = i + dx, j + dy
                    if (0 <= n_r < m and 0 <= n_c < n) and board[n_r][n_c] == 'E' and (n_r, n_c) not in visited:
                        queue.append((n_r, n_c))
                        visited.add((n_r, n_c))


        return board