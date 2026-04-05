class Solution:
    def isPalindrome(self, s: str) -> bool:
        clean = []

        for c in s:
            if ord('A') <= ord(c) <= ord('Z'):
                c = chr(ord(c)-ord('A')+ord('a'))
            
            if ord('a') <= ord(c) <= ord('z') or ord('0') <= ord(c) <= ord('9'):
                clean.append(c)

        return ''.join(clean) == ''.join(clean[::-1])