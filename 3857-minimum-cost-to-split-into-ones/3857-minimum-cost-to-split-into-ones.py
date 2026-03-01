class Solution:
    def minCost(self, n: int) -> int:
        cost = 0
        q = []
        q.append(n)

        while (len(q) > 0):
            x = q.pop(0)
            m = x // 2
            r = x - m

            cost += m * r
            if m > 1:
                q.append(m)
            if r > 1:
                q.append(r)

        return cost