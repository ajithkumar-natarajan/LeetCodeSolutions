from dataclasses import dataclass
import heapq

@dataclass
class char:
    c: str
    count: int

class Solution:
    def reorganizeString(self, s: str) -> str:

        """
        string -> arrange -> aranger

        [3,1,1,1,0] -> abcde
        aabacd -> bacada or abacad
        [3,1,1,1,0] -> [1,0,1,1,0]
        counter -> [1,1,0,1,0]
        prev_c -> 'a'
        aba

        aabcb -> [2,2,1]
        dictionary -> {2: [a, b], 1: [c]}

        if max(counter) > len(string)//2 -> not possible

        """

        dictionary = {}
        result = ['']
        
        # for c in characters:
        #     obj = char(c=c, count=0)
        #     dictionary[c] = obj
        
        
        for c in s:
            count = dictionary.get(c, 0)
            dictionary[c] = count + 1

        pq = []

        for char, freq in dictionary.items():
            pq.append((-freq, char))


        # print(pq)
        heapq.heapify(pq)
        # print(pq)

        while pq:
            freq, char = heapq.heappop(pq)
            # print(freq, char)
            # print(result)
            if result[-1] != char:
                    result.append(char)
                    freq += 1
                    if freq < 0:
                        pq.append((freq, char))
                        heapq.heapify(pq)
            elif pq:
                freq2, char2 = heapq.heappop(pq)
                heapq.heappush(pq, (freq, char))
                result.append(char2)
                freq2 += 1
                if freq2 < 0:
                    pq.append((freq2, char2))
                    heapq.heapify(pq)
        # for key in dictionary.keys():
        #     obj = dictionary.get(c)
        #     counter[ord(c)-ord('a')] += 1
            
        # for count, char in enumerate(counter):
        #     dictionary[]
        # print(counter)
        
        result.pop(0)
        if len(result) == len(s):
            return ''.join(result)
        return ''