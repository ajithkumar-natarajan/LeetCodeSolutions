class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        ans = 0

        row_sum = []
        col_sum = []

        for i in range(len(mat)):
            total = 0
            index = 0
            for j in range(len(mat[0])):
                if mat[i][j] == 1:
                    total += mat[i][j]
                    index = j
            if total == 1:
                t = 0
                for j in range(len(mat)):
                    t += mat[j][index]
                if t == 1:
                    ans += 1

        return ans