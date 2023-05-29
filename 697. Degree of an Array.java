class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int minLen = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> firstSeen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            firstSeen.putIfAbsent(nums[i], i);
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            if(frequency.get(nums[i]) > degree) {
                degree = frequency.get(nums[i]);
                minLen = i - firstSeen.get(nums[i]) + 1;
            }

            else if(frequency.get(nums[i]) == degree) {
                minLen = Math.min(minLen, i - firstSeen.get(nums[i]) + 1);
            }
        }
        return minLen;
    }
}
