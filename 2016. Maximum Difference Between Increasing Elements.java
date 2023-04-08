class Solution {
    public int maximumDifference(int[] nums) {
        if(nums == null || nums.length  < 2)
            return -1;
        int ans = -1;
        int min = nums[0];

        
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] > min) {
                ans = Math.max(ans, nums[i]-min);
            }
            else {
                min = nums[i];
            }
        }
        return ans;
    }
}
