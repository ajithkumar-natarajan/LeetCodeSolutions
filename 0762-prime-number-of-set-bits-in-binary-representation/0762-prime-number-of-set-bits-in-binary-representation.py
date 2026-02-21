class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        output = 0
        for i in range(left, right+1):
            if (self.is_prime(bin(i)[2:].count('1'))):
                output += 1
        
        return output

    def is_prime(self, n):
        if n == 1:
            return False
        if n == 2:
            return True
        if n % 2 == 0:
            return False

        for i in range(3, int(math.sqrt(n))+1, 2):
            if n % i == 0:
                return False
        return True