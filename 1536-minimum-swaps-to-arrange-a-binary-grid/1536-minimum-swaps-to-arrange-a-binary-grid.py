class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        target = []
        current = []
        n = len(grid)
        ans = 0

        for i in range(n):
            count = 0
            for j in range(n-1, -1, -1):
                if grid[i][j] == 0:
                    count += 1
                else:
                    break
            current.append(count)
        
        for i in range(n):
            target.append(n-i-1)

        for i, x in enumerate(target):
            not_found = True
            for j in range(i, n):
                if current[j] >= x:
                    not_found = False
                    while (j > i):
                        current[j-1], current[j] = current[j], current[j-1]
                        j -= 1
                        ans += 1
                    break
            if not_found:
                return -1


        return ans