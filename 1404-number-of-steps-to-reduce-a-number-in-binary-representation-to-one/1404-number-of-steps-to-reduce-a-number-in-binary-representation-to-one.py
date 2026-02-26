class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        s_int = int(s, 2)
        
        while s_int > 1:
            print(s_int)
            if s_int % 2 == 0:
                s_int //= 2
            else:
                s_int += 1
            
            steps += 1

        return steps