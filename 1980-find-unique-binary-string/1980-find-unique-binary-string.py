class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        def frameBinaryStrings(height, current_level, bin_set):
            temp_set = set()
            for item in bin_set:
                temp_set.add(item+'0')
                temp_set.add(item+'1')

            if current_level >= height:
                return temp_set
            else:
                return frameBinaryStrings(height, current_level+1, temp_set)

        levels = len(nums[0])
        bin_set = {}

        if levels == 1:
            bin_set = {'0', '1'}
        else:
            bin_set = frameBinaryStrings(len(nums[0]), 2, {'0', '1'})

        for item in bin_set:
            if item not in nums:
                return item

        return '0'