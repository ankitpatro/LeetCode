class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = inserInterval(intervals, newInterval);

        return mergeIntervals(intervals);
    }

    private int[][] mergeIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        int[] currentInterval = intervals[0];
        list.add(currentInterval);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            }

            else {
                currentInterval = intervals[i];
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][]);
    }

    private int[][] inserInterval(int[][] intervals, int[] newInterval) {
        boolean isInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        for(int i = 0; i < intervals.length; i++) {
            if(newInterval[0] < intervals[i][0]) {

                list.add(i, newInterval);
                isInserted = true;
                break;
            }
        }

        if(!isInserted) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
