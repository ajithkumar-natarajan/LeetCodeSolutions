class Solution:
    def isValid(self, s: str) -> bool:
        m = {')': '(', '}': '{', ']': '['}
        stack = []

        for c in s:
            if c in m:
                if not stack or not m[c] == stack.pop():
                    return False
            else:
                stack.append(c)

        if not stack:
            return True
        return False