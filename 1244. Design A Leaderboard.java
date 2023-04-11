class Leaderboard {

    Map<Integer, Integer> idToScore;

    public Leaderboard() {
        this.idToScore = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!idToScore.containsKey(playerId)) {
            idToScore.put(playerId, score);
        }
        else {
            idToScore.put(playerId, idToScore.get(playerId) + score);
        }
    }      
    
    public int top(int K) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });

        for(Map.Entry<Integer, Integer> entry : idToScore.entrySet()) {
            pq.offer(entry);

            if(pq.size() > K) {
                pq.poll();
            }
        }
        int topK = 0;
        Iterator it = pq.iterator();

        while(it.hasNext()) {
            topK += ((Map.Entry<Integer, Integer>)it.next()).getValue();
        }
        return topK;
    }
    
    public void reset(int playerId) {
        idToScore.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
