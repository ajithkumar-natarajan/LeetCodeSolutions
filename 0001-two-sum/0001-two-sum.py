class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = dict()

        for i, n in enumerate(nums):
            idx = d.get(target-n, -1)

            if idx != -1:
                return [i, idx]
            else:
                d[n] = i

        return 0