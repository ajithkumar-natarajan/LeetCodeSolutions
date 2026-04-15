class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = dict()
        longest = 0
        prev = 0

        for idx, c in enumerate(s):
            if c in hashmap:
                if hashmap[c] >= prev:
                    prev = hashmap[c] + 1 
            hashmap[c] = idx
            longest = max(longest, idx-prev+1)
        
        return longest
