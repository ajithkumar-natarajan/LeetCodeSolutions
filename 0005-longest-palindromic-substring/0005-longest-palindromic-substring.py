class Solution:
    def longestPalindrome(self, s: str) -> str:
        ptr = 0
        max_len = 1
        ans = s[0]

        for ptr in range(0, len(s)):
            left = ptr-1
            right = ptr+1

            while 0 <= left and right < len(s):
                if s[left] == s[right]:
                    if (right-left+1) > max_len:
                        max_len = right - left + 1
                        ans = s[left:right+1]
                    left -= 1
                    right += 1
                else:
                    break

            left = ptr
            right = ptr+1

            while 0 <= left and right < len(s):
                if s[left] == s[right]:
                    if (right-left+1) > max_len:
                        max_len = right - left + 1
                        ans = s[left:right+1]
                    left -= 1
                    right += 1
                else:
                    break

        return ans