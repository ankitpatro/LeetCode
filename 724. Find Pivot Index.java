class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1;

        int rightSum = 0 ;
        int leftSum = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for(int i = 0; i < nums.length; i++) {

            if(leftSum == rightSum) {
                return i;
            }

 
            leftSum = leftSum + nums[i];
            if(i < nums.length -1)
            rightSum = rightSum - nums[i + 1];
        }

        return -1;
    }
}
