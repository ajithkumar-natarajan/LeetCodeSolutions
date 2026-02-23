class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        # if len(s) < k:
        #     return False

        # l = [0]*k
        # l.extend([1]*k)
        # combinations = itertools.combinations(l, k)
        # codes = set()

        # def get_codes(t):
        #     code = []
        #     for x in t:
        #         code.append(str(x))
        #     codes.add(''.join(code))
        #     code.reverse()
        #     codes.add(''.join(code))


        # for comb in combinations:
        #     get_codes(comb)

        # for code in codes:
        #     if not code in s:
        #         return False

        # return True

        substring = set()

        for i in range(len(s)-k+1):
            substring.add(s[i:i+k])

        return len(substring) == math.pow(2, k)