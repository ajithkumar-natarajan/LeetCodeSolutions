class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:

        graph = defaultdict(defaultdict)
        
        def find_path(start, target):
            queue = deque([(start, 1.0)])
            visited = {start}
            
            while queue:
                curr_node, curr_prod = queue.popleft()
                
                if curr_node == target:
                    return curr_prod
                
                for neighbor, value in graph[curr_node].items():
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append((neighbor, curr_prod * value))
            
            return -1.0

        results = []
        for (dividend, divisor), value in zip(equations, values):
            graph[dividend][divisor] = value
            graph[divisor][dividend] = 1/value

        for dividend, divisor in queries:
            if dividend not in graph or divisor not in graph:
                ans = -1
            elif dividend == divisor:
                ans = 1
            else:
                visited = set()
                ans = find_path(dividend, divisor)
            results.append(ans)

        return results
