class Solution {
    public int numSubseq(int[] nums, int target) {
        int right = nums.length - 1;
        int mod = 1000000007;
        Arrays.sort(nums);
        int result = 0;

        int left = 0;
          int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        while(left <= right) {
            if(nums[right] + nums[left] > target) {
                right--;
            }

            else {
                result += power[right - left];
                result = result % mod;
                left++;
            }
        }
        return result;
    }
}
