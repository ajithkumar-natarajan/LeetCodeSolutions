class Solution:
    def longestBalanced(self, s: str) -> int:
        result = 0

        for i in range(len(s)):
            count = [0]*26
            uniq = max_freq = 0
            for j in range(i, len(s)):
                c = s[j]
                if (count[ord(c)-97] == 0):
                    uniq += 1
                count[ord(c)-97] += 1

                max_freq = max(count[ord(c)-97], max_freq)
            
                if uniq * max_freq == (j-i+1):
                    result = max(uniq*max_freq, result)

        return result
