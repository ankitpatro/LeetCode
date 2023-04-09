class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();

        if(intervals == null || intervals.length == 0) {
            return null;
            //  mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        mergedIntervals.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            int[] newInterval = intervals[i];
            int[] currentInterval = mergedIntervals.get(mergedIntervals.size()-1);

            if(newInterval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
            }
            else {
                mergedIntervals.add(intervals[i]);
            }
        }
    return mergedIntervals.toArray(new int[0][]);

    }
}
