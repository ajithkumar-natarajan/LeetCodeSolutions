class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        Set<Integer> tempSet = new HashSet<>();
        tempSet.add(0);
        
        while(!tempSet.isEmpty()){
            Set<Integer> temp = new HashSet<>(tempSet);
            tempSet.clear();
            for(int i: temp){
                for(int j: rooms.get(i)){
                    if(!set.contains(j))
                        tempSet.add(j);
                }
            }
            set.addAll(tempSet);
        }
        
        
        if(rooms.size() == set.size())
            return true;
        return false;
    }
}