class Solution:
    def countSubstrings(self, s: str) -> int:
        pali = []
        
        ptr = 0
        for ptr in range(len(s)):
            left = ptr
            right = ptr

            while 0 <= left and right < len(s):
                if s[left] == s[right]:
                    pali.append(s[left:right+1])
                    # print("1", s[left:right+1], ptr, left, right)
                else:
                    break
                left -= 1
                right += 1

            left = ptr
            right = ptr+1

            while 0 <= left and right < len(s):
                if s[left] == s[right]:
                    pali.append(s[left:right+1])
                    # print("2", s[left:right+1], ptr, left, right)
                else:
                    break
                left -= 1
                right += 1

        # print(pali)

        return len(pali)