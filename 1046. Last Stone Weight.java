class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });

        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            pq.offer(stone1 - stone2);
        }

        return pq.poll();
    }
}
