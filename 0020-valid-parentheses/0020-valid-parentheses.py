class Solution:
    def isValid(self, s: str) -> bool:
        m = {')': '(', '}': '{', ']': '['}
        stack = []

        for c in s:
            if c in m:
                if not stack or stack.pop() != m[c]:
                    return False
            else:
                stack.append(c)
        
        if len(stack) > 0:
            return False

        return True