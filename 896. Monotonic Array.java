class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false;
        int len = nums.length;
        if(nums[0] <= nums[len - 1]) {
            isIncreasing = true;
        }

        for(int i = 1; i < len; i++) {
            if(isIncreasing) {
                if(nums[i-1] > nums[i]) {
                    return false;
                }
            }

            else {
                if(nums[i] > nums[i-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
