class Solution {
    public int minTaps(int n, int[] ranges) {
        int left = 0;
        int right = 0;
        int taps = 0;

        while(right < n) {
            for(int i = 0; i < ranges.length; i++) {
                if(i - ranges[i] <= left && i + ranges[i] > right) {
                right = i + ranges[i];
            }
         }
            if(left == right) {
                return -1;
            }
            taps++;
            left = right;
        }

        return taps;
    }
}
