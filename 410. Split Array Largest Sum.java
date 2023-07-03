class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int l = max;
        int r = sum;
        int result = r;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(canSplit(nums, mid, k)) {
                result = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int threshold, int k) {
        int subArrays = 0;
        int currentSum = 0;

        for(int num : nums) {
            if((currentSum + num) > threshold) {
                subArrays++;
                currentSum = num;
            }

            else {
                currentSum +=num;
            }
        }
        return subArrays + 1 <= k;

    }
}
