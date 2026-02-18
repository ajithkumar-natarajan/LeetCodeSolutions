class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        binary = bin(n)[2:]
        alt = 0

        for c in binary:
            if c == '0':
                if alt == 1:
                    alt = 0
                else:
                    return False
            else:
                if alt == 0:
                    alt = 1 
                else:
                    return False

        return True