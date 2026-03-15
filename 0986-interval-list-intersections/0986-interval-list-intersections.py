class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        ptr1 = 0
        ptr2 = 0
        merge = []

        while ptr1 < len(firstList) and ptr2 < len(secondList):
            if firstList[ptr1][0] <= secondList[ptr2][0] <= firstList[ptr1][1]:
                merge.append([secondList[ptr2][0], min(secondList[ptr2][1], firstList[ptr1][1])])
                if firstList[ptr1][1] < secondList[ptr2][1]:
                    ptr1 += 1
                elif firstList[ptr1][1] > secondList[ptr2][1]:
                    ptr2 += 1
                else:
                    ptr1 += 1
                    ptr2 += 1
            elif secondList[ptr2][0] <= firstList[ptr1][0] <= secondList[ptr2][1]:
                merge.append([firstList[ptr1][0], min(secondList[ptr2][1], firstList[ptr1][1])])
                if firstList[ptr1][1] < secondList[ptr2][1]:
                    ptr1 += 1
                elif firstList[ptr1][1] > secondList[ptr2][1]:
                    ptr2 += 1
                else:
                    ptr1 += 1
                    ptr2 += 1
            else:
                if firstList[ptr1][1] > secondList[ptr2][1]:
                    ptr2 += 1
                else:
                    ptr1 += 1
        
        return merge
