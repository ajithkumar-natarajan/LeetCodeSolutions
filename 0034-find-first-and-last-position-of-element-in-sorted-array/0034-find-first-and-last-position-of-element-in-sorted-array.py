class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def get_mid(left, right):
            if left > right:
                return -1
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                return get_mid(left, mid-1)
            else:
                return get_mid(mid+1, right)

        mid = get_mid(0, len(nums)-1)

        i = j = -1

        if mid != -1:
            i = mid
            while i>0 and nums[i-1] == target:
                i -= 1
            
            j = mid
            while j<len(nums)-1 and nums[j+1] == target:
                j += 1

        return [i, j]