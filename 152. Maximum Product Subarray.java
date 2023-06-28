class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currMax = 1;
        int currMin = 1;

        for(int num : nums) {

            int newMax = Math.max(Math.max(num * currMax, num * currMin), num);
            int newMin = Math.min(Math.min(num * currMax, num * currMin), num);

            currMax = newMax;
            currMin = newMin;
            result = Math.max(result, currMax);
        }

        return result;
    }
}
