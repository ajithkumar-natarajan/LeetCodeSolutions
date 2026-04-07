class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)

        for r in range(n//2):
            for c in range(n):
                matrix[r][c], matrix[n-r-1][c] = matrix[n-r-1][c], matrix[r][c]

        for r in range(n):
            for c in range(r+1, n):
                matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]