class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n-1));
        
    }

    private int helper(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;

        for(int i = start; i <= end; i++) {
            int newMax = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = newMax;
        }

        return rob2;
    }
}
