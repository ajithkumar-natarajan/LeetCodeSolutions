class Solution:
    def minDistinctFreqPair(self, nums: list[int]) -> list[int]:
        nums.sort()
        count = [0]*100

        for x in nums:
            count[x-1] += 1

        for i, x in enumerate(count):
            if x == 0:
                continue
            for j in range(i+1, len(count)):
                if x != count[j] and count[j] != 0:
                    return [i+1, j+1]

        return [-1, -1]