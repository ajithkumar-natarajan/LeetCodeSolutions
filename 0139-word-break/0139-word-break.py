class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        ptr = 0
        dp = [False] * (len(s)+1)
        dp[0] = True
        word_set = set(wordDict)


        for ptr in range(len(s)+1):
            for i in range(ptr):
                if dp[i] and s[i:ptr] in word_set:
                    dp[ptr] = True
        
        return dp[-1]