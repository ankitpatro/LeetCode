class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            int target = 0-nums[i];
            while(start < end) {
                if(nums[start] + nums[end] > target) {
                    end--;
                }

                else if(nums[start] + nums[end] < target) {
                    start++;
                }

                else {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    while(start < end && nums[start] == nums[start-1]) {
                        start++;
                    } 
                }
            }
        }

        return result;
    }
}
