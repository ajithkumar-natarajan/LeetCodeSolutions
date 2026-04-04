class Solution:
    def countBits(self, n: int) -> List[int]:
        if n == 0:
            return [0]

        result = [0]
        mul = 1

        for i in range(1, n+1):
            if mul * 2 == i:
                mul = i
            result.append(result[i-mul]+1)
            
        return result