class Solution {
    Map<Integer, Integer> numToPower = new HashMap<>();
    public int getKth(int lo, int hi, int k) {

        numToPower.put(1, 0);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int powerA = power(a);
            int powerB = power(b);

            if(powerA != powerB) {
                return powerB - powerA;
            }

            else {
                return b - a;
            }
        });

        for(int i = lo; i <= hi; i++) {
            pq.offer(i);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
        
    }


    private int power(int num) {
        if(numToPower.containsKey(num)) {
            return numToPower.get(num);
        }

        
        int steps = 1 + ((num % 2 == 0) ? power(num / 2) : power( 3 * num + 1));

        numToPower.put(num, steps);
        return steps;
    }
}
