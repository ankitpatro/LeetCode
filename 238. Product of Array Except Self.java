class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        //________________Using Two Arrays- Left & Right____________________
        // int[] left = new int[n];
        // int[] right = new int[n];
        int[] result = new int[n];

        // left[0] = 1;
        // right[n-1] = 1;

        // for(int i = 1; i < n; i++) {
        //     left[i] = left[i-1] * nums[i-1];
        // }

        // for(int i = n-2; i >= 0; i--) {
        //     right[i] = right[i + 1] * nums[i + 1];
        // }

        // for(int i = 0; i < n; i++) {
        //     result[i] = left[i] * right[i];
        // }
        // return result;
// ______________________________________________________________________________________

// _______________Using No Extra Space____________________________________________________
        int right = 1;
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        for(int i = n-1; i >=0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }
}
