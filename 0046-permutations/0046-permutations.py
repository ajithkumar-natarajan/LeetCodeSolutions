class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        # In Python, we initialize the 'used' list with False
        used = [False] * len(nums)
        
        # To handle duplicates correctly the array must be sorted.
        # nums.sort() 
        
        def permutations(current_list):
            # Base case: if the current list is the same length as nums
            if len(current_list) == len(nums):
                res.append(list(current_list)) # Append a copy
                return
            
            for i in range(len(nums)):
                # Check if element is already used in this branch
                # The first part of the 'if' handles duplicate numbers in the input
                if used[i]:# or (i > 0 and nums[i] == nums[i-1] and not used[i-1]):
                    continue
                
                # Pre-recursion (Choose)
                used[i] = True
                current_list.append(nums[i])
                
                # Recurse
                permutations(current_list)
                
                # Post-recursion (Backtrack/Undo)
                current_list.pop()
                used[i] = False
                
        permutations([])
        return res