class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []

        def generate(current_list, index):
            # Base case: if we've considered all elements
            if index == len(nums):
                # Append a copy of the current_list
                result.append(list(current_list))
                return
            
            # Decision 1: Include nums[index]
            current_list.append(nums[index])
            generate(current_list, index + 1)

            # Backtrack: Remove nums[index] to explore the "exclude" path
            current_list.pop()

            # Decision 2: Exclude nums[index]
            generate(current_list, index + 1)

            return
        
        generate([], 0)

        return result