class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];

        for(int num : nums) {
            freq[num]++;
        }
        int i = 0;
        while(i < nums.length) {
            while(freq[0] > 0) {
                nums[i++] = 0;
                freq[0]--; 
            }

            while(freq[1] > 0) {
                nums[i++] = 1;
                freq[1]--; 
            }

            while(freq[2] > 0) {
                nums[i++] = 2;
                freq[2]--; 
            }
        }
    }
}
