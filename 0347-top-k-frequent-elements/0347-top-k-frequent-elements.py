class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)

        heap = [(-y, x) for x, y in count.items()]

        heapq.heapify(heap)

        result = []

        for i in range(k):
            result.append(heapq.heappop(heap)[1])

        return result