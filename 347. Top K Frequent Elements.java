class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();

        for(int num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            return numToFrequency.get(a) - numToFrequency.get(b);
        });
        for(Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
            pq.offer(entry.getKey());
            if(pq.size() > k) {
                pq.remove();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
