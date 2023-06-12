class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for(int num : arr) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for(Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        while(k > 0) {
            int[] element = pq.peek();
            if(element[1] == 1) {
                pq.poll();
            }

            else {
                element[1]--;
            }

            k--;
        }

        return pq.size();
    }

}
