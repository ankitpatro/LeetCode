class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] -b[0];
        });
        int result = 0;

        int[] prevInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if(prevInterval[1] <= intervals[i][0]) {
                prevInterval[1] = intervals[i][1];
            }

            else {
                result++;
                prevInterval[1] = Math.min(prevInterval[1], intervals[i][1]);
            }
        }

        return result;

    }
}
