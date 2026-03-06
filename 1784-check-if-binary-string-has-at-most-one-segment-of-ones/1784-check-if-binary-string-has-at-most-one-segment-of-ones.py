class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        flag = False
        for c in s:
            if c == '0':
                flag = True
            else:
                if flag:
                    return False
        return True