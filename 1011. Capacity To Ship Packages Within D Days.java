class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;
        for(int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }

        int result = totalLoad;
        int l = maxLoad, r = totalLoad;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(canShip(weights, days, mid)) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return l;


    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int numDays = 1;
        int currentCapacity = capacity;
        for(int weight : weights) {
            if(currentCapacity - weight < 0) {
                numDays++;
                currentCapacity = capacity;
            }

            currentCapacity -= weight;
        }

        return numDays <= days;
    }
}
