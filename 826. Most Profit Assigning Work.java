class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int N = profit.length;
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            jobs.add(new Pair<Integer, Integer>(difficulty[i], profit[i]));
        }

        Collections.sort(jobs, (a, b) -> {
            return a.getKey() - b.getKey();
        });

        Arrays.sort(worker);

        int result = 0; 
        int best = 0;
        int i = 0;

        for(int ability : worker) {
            while(i < N && ability >= jobs.get(i).getKey()) {
                best = Math.max(best, jobs.get(i).getValue());
                i++;
            }

            result = result + best;
        }
        return result;
    }
    
}
