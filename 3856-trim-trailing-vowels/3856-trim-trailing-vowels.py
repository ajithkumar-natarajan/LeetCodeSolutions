class Solution:
    def trimTrailingVowels(self, s: str) -> str:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        s_l = list(s)

        for i in range(len(s_l)-1, -1, -1):
            if s_l[i] in vowels:
                s_l.pop(i)
            else:
                break

        return ''.join(s_l)