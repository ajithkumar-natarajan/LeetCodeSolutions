class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        m = len(board)
        n = len(board[0])

        def dfs(x, y, pos):
            if pos == len(word):
                return True
            if x < 0 or x >= m or y < 0 or y >= n:
                return False
            if board[x][y] != word[pos]:
                return False
            
            temp = board[x][y]
            board[x][y] = '#'
            if dfs(x, y+1, pos+1) or dfs(x, y-1, pos+1) or dfs(x+1, y, pos+1) or dfs(x-1, y, pos+1):
                return True
            board[x][y] = temp

            return False

        for i in range(m):
            for j in range(n):
                if dfs(i, j, 0):
                    return True
        return False