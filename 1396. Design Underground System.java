class UndergroundSystem {

    Map<Integer, Arrivals> arrivalsMap;
    Map<String, Averages> averageMap;

    public UndergroundSystem() {
        arrivalsMap = new HashMap<>();
        averageMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Arrivals arrival = new Arrivals(stationName, t);
        arrivalsMap.put(id, arrival);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Arrivals arrival = arrivalsMap.get(id);
        String startStation = arrival.station;
        int startTime = arrival.time;

        String stationAlias = startStation + "-" + stationName;

        Averages averageObj = averageMap.containsKey(stationAlias) ? averageMap.get(stationAlias) : new Averages();
        averageObj.updateAverage(t - startTime);
        averageMap.put(stationAlias, averageObj);

        arrivalsMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String stationAlias = startStation + "-" + endStation;
        return averageMap.get(stationAlias).getAverage();
    }

    class Arrivals {
        String station;
        int time;

        public Arrivals(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Averages {
        double totalTime;
        int count;

        public void updateAverage(int diff) {
            this.totalTime  += diff;
            this.count++;
        }

        public double getAverage() {
            return this.totalTime / this.count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
