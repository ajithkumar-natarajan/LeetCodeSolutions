class UndergroundSystem {
    Map<String, String> map;
    Map<Integer, Pair<String, Integer>> pairmap;
    public UndergroundSystem() {
        map = new HashMap<>();
        pairmap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair<String, Integer> pair = new Pair<>(stationName, t);
        pairmap.put(id, pair);
        // System.out.println(Arrays.toString(arr));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = pairmap.get(id);
        int i = pair.getValue();
        String str = map.getOrDefault(pair.getKey()+stationName, "0-0");
        String[] arr = str.split("-");
        double time = t-i;
        int count = Integer.parseInt(arr[1]);
        time += Double.parseDouble(arr[0])*count;
        time /= ++count;
        map.put(pair.getKey()+stationName, time+"-"+count);
        // System.out.println("Checkout "+map);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        // System.out.println("Avg "+map);
        return Double.parseDouble(map.get(startStation+endStation).split("-")[0]);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */