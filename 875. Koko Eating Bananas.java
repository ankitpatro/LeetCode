class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        int result = max;

        while(left <= right) {
            int k = (left + right) / 2;

            int time = 0;
            for(int pile : piles) {
                time += Math.ceil((double)pile/k);
            }

            if(time <= h) {
                result = Math.min(result, k);
                right = k - 1;
            }

            else {
                left = k + 1;
            }
        }

        return result;
    }
}
