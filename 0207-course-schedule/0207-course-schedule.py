class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        pre_map = {i: [] for i in range(numCourses)}
        visited = set()

        for prereq in prerequisites:
            pre = pre_map.get(prereq[0])
            pre.append(prereq[1])
            pre_map[prereq[0]] = pre
        

        def check(course):
            if course in visited:
                return False
            if pre_map[course] == []:
                return True
            
            visited.add(course)
            for crse in pre_map[course]:
                if not check(crse):
                    return False
            visited.remove(course)
            pre_map[course] = []
            return True

        for course in range(numCourses):
            if not check(course):
                return False

        return True