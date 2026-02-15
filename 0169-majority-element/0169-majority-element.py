class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count_map = dict()
        length = len(nums)

        for n in nums:
            count = count_map.get(n, 0)
            count += 1
            count_map[n] = count

            if count > length//2:
                return n

        return 0