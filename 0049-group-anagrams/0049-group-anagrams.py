class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = dict()
        res = []

        for i, word in enumerate(strs):
            word_list = list(word)
            word_list.sort()
            word_tuple = tuple(word_list)
            # print(word_tuple)

            x = d.get(word_tuple, [])
            x.append(i)
            d[word_tuple] = x

        for key in d.keys():
            group = []
            for i in d.get(key):
                group.append(strs[i])
            res.append(group)

        # print(res)

        return res