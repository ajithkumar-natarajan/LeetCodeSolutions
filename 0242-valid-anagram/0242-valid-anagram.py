class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        alphabets = [0]*26

        for c in s:
            alphabets[ord(c)-97] += 1
        
        for c in t:
            alphabets[ord(c)-97] -= 1

        for n in alphabets:
            if n != 0:
                return False
        return True