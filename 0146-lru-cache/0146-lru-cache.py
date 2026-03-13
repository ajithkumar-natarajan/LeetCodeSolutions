class LRUCache:

    def __init__(self, capacity):
        self.cache = {}
        self.capacity = capacity
    
    def get(self, key):
        if not key in self.cache:
            return -1

        val = self.cache.get(key)
        del self.cache[key]
        self.cache[key] = val

        return val

    def put(self, key, value):
        if key in self.cache:
            del self.cache[key]
            self.cache[key] = value
            
            return

        if len(self.cache) == self.capacity:
            del self.cache[list(self.cache.keys())[0]]
        self.cache[key] = value

        return

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)