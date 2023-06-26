class Solution {
    public int firstMissingPositive(int[] nums) {

// *******************Naive Method*************************
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums) {
        //     if(num > 0)
        //     set.add(num);
        // }

        // for(int i = 1; i <= nums.length + 1; i++) {
        //     if(!set.contains(i)) {
        //         return i;
        //     }
        // }

        // return -1;
        // ***********************************************


    for(int i = 0; i < nums.length; i++) {
        if(nums[i] < 0) {
            nums[i] = 0;
        }
    }

    for(int i = 0; i < nums.length; i++) {
        int val = Math.abs(nums[i]);
        if(val >= 1 && val <= nums.length) {
            if(nums[val -1] > 0) {
                nums[val -1] = -1 * nums[val - 1];
            }

            else if(nums[val -1] == 0) {
                nums[val - 1] = -1 * (nums.length + 1);
            }
        }
    }

    for(int i = 1; i < nums.length + 1; i++) {
        if(nums[i - 1] >= 0) {
            return i;
        }
    }
    return nums.length + 1;
    }

    /**
 public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        } 

        int n = nums.length;
        boolean hasOne = false;

        //Step 1
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                hasOne = true;
            }
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if(!hasOne) {
            return 1;
        }

        //Step 2
        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        //Step 3

        for(int i = 1; i <= n; i++) {
            if(nums[i-1] > 0) {
                return i;
            }
        }

        return n + 1;
    }
    */
}
