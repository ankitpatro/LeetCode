class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // for(int i = 1; i < nums.length; i++) {
        //     for(int j = 0; j < i; j++)
        //     {
        //         if(nums[i] > nums[j]) {
        //             dp[i] = Math.max(dp[i], 1 + dp[j]);
        //         }
        //     }
        // }
//O(n^2)
        int n = nums.length;

        for(int i = n-1; i >= 0; i--) {
            for(int j = i +1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int longest = 0;
        for(int value : dp) longest = Math.max(longest, value);

        return longest;
    }
}
