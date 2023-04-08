class Job{
    int start;
    int end;
    int profit;
    Job(int start,int end,int profit){
        this.start= start;
        this.end = end;
        this.profit= profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a,b)-> {
            return a.end - b.end;
        });
// ----------------TUSHAR ROY-------------------------------
        int T[] = new int[jobs.length];
        T[0] = jobs[0].profit;

        for(int i = 1; i < jobs.length; i++) {
            T[i] = Math.max(jobs[i].profit, T[i-1]);
            for(int j = i-1; j >=0; j--) {
                if(jobs[j].end <= jobs[i].start) {
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
                    break;
                }
            }
        }

        //         int maxVal = Integer.MIN_VALUE;
        // for (int val : T) {
        //     if (maxVal < val) {
        //         maxVal = val;
        //     }
        // }
        return T[T.length - 1];

        // ----------------------------------------------------------------------

//     TreeMap<Integer, Integer> endTimeToTotalProfit = new TreeMap<>();
//     int maxProfit = 0;
//     for(Job job : jobs) {
//         Integer entryListStartTime = endTimeToTotalProfit.floorKey(job.start);
//         Integer maxProfitTillStartTime = entryListStartTime == null ? 0 : endTimeToTotalProfit.get(entryListStartTime);

//         maxProfit = Math.max(maxProfit, maxProfitTillStartTime + job.profit);
//         endTimeToTotalProfit.put(job.end, maxProfit);
//     }
// return maxProfit;
    }
}
