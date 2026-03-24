class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None

class LRUCache:
    def __init__(self, capacity):
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.cap = capacity
        self.m = {}

    def _remove(self, node):
        p = node.prev
        n = node.next
        p.next = n
        n.prev = p


    def _add(self, node):
        n = self.head.next
        p = self.head.next.prev
        self.head.next = node
        node.prev = self.head
        node.next = n
        n.prev = node
    
    def get(self, key):
        if key in self.m:
            node = self.m.get(key)
            self._remove(node)
            self._add(node)

            return node.val
        return -1

    
    def put(self, key, value):
        if key in self.m:
            node = self.m.get(key)
            node.val = value
            self._remove(node)
            self._add(node)
        
            return

        node = Node(key, value)
        self.m[key] = node
        self._add(node)

        if len(self.m) > self.cap:
            k = self.tail.prev.key
            self._remove(self.tail.prev)
            del self.m[k]


    # def __init__(self, capacity):
    #     self.cache = {}
    #     self.capacity = capacity
    
    # def get(self, key):
    #     if not key in self.cache:
    #         return -1

    #     val = self.cache.get(key)
    #     del self.cache[key]
    #     self.cache[key] = val

    #     return val

    # def put(self, key, value):
    #     if key in self.cache:
    #         del self.cache[key]
    #         self.cache[key] = value
            
    #         return

    #     if len(self.cache) == self.capacity:
    #         del self.cache[list(self.cache.keys())[0]]
    #     self.cache[key] = value

    #     return

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)