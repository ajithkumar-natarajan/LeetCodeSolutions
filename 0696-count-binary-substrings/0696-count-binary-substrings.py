class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        consecutive_repeats = []
        prev_c = s[0]
        count = 1

        for c in s[1:]:
            if c == prev_c:
                count += 1
            else:
                consecutive_repeats.append(count)
                count = 1
            prev_c = c

        consecutive_repeats.append(count)
        ans = 0

        for i in range(1, len(consecutive_repeats)):
            ans += min(consecutive_repeats[i], consecutive_repeats[i-1])

        return ans