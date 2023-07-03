class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<int[]> profitQueue = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });

        for(int i = 0; i <  profits.length; i++) {
            capitalQueue.offer(new int[]{capital[i], profits[i]});
        }

        while(k > 0) {
            k--;
            while(!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= w) {
                int[] capitalAndProfit = capitalQueue.poll();
                profitQueue.offer(capitalAndProfit);
            }

            if(profitQueue.isEmpty()) {
                break;
            }

            w += profitQueue.poll()[1];


        }

        return w;
    }
}
