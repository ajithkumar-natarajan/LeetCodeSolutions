class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.cache_order = []

    def get(self, key: int) -> int:
        result = self.cache.get(key, -1)
        if result != -1:
            index = self.cache_order.index(key)
            self.cache_order.pop(index)
            self.cache_order.insert(0, key)
        return result

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = value
            index = self.cache_order.index(key)
            self.cache_order.pop(index)
            self.cache_order.insert(0, key)
            return

        current_len = len(self.cache_order)
        if current_len == self.capacity:
            item = self.cache_order.pop(-1)
            del self.cache[item]
        self.cache_order.insert(0, key)
        self.cache[key] = value
        return



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)