class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = dict()
        left = 0
        right = 0
        ans = 0

        for right, c in enumerate(s):
            if c in hashmap:
                left = max(hashmap.get(c)+1, left)
            hashmap[c] = right
            
            ans = max(right-left+1, ans)

        return ans