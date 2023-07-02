class Solution {
    public int maxEvents(int[][] events) {
        //Priority Queue keeps entry of end day of the events(min heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //sort the events array based on start time
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });

        int i = 0, result = 0, n = events.length, d = 0;

        while(i < n || !pq.isEmpty()) {
            if(pq.isEmpty()) {
                //assign start day of ith event to 'd' if pq is empty 
                d = events[i][0];
            }

            // add all end dates whose corresponding start date < 'd'
            while(i < n && events[i][0] <= d) {
                pq.offer(events[i][1]);
                i++;
            }

        // retrieve the event with earliest end date from pq
            pq.poll();

            //increment result
            result++;

            //increment d, as there can only 1 event that can be attended
            d++;

            //invalid events which has been ended before 'd' -> remove them from q
            while(!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
        }

        return result;


    }
}
