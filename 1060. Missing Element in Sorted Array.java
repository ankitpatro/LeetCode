class Solution {
    public int missingElement(int[] nums, int k) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int missing  = nums[right] - nums[left] - (right - left);

        if(missing < k) {
            return nums[right] + k - missing;
        }

        while(left < right - 1) {
            int mid = left + (right - left) / 2;
             missing = nums[mid] - nums[left] - (mid - left);

            if(missing >= k) {
                right = mid;
            }

            else {
                k = k - missing;
                left = mid;
            }
        }

        return nums[left] + k;
        }

        /**
--------Brute Force---------------------------------------
         */
//    {
//       for(int i = 0; i < nums.length - 1; i++) {
//          int diff = nums[i+1] - nums[i] - 1;
//          if(diff == 0) continue;
//          if(k - diff < 0) {
//              return nums[i] + k;
//          }

//          if(k - diff == 0) {
//              if(nums[i+1] - nums[i] < 2){
//                  continue;
//              }

//              else {
//                  return nums[i] + k;
//              }
//          }

//          else {
//              k = k - diff;
//          }
//      }

//      return nums[nums.length - 1] + k;
//     }
}
