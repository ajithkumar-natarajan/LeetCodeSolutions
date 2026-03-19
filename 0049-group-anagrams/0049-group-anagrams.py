class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = dict()
        res = []

        for i, word in enumerate(strs):
            word_list = list(word)
            word_list.sort()
            word_tuple = tuple(word_list)

            x = d.get(word_tuple, [])
            x.append(word)
            d[word_tuple] = x

        return list(d.values())