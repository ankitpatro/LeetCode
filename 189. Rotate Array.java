class Solution {

        private void reverse(int[] nums, int start, int end) {
            while(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        } 

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);





//-----------------Using temp array and calculate new index--------------        

        // int temp[] = new int[nums.length];

        // k = k % nums.length;
        // for(int i = 0; i < nums.length; i++) {
        //     int index = (i + k) % nums.length;
        //     temp[index] = nums[i];
        // }

        // for(int i = 0; i < nums.length; i++) {
        //     nums[i] = temp[i];
        // }
        

 //----------------Using Queue--------------------------       
        // LinkedList<Integer> queue = new LinkedList<>();
        // for(int num : nums) {
        //     queue.offer(num);
        // }

        // while(k > 0) {
        //     queue.addFirst(queue.removeLast());
        //     k--;
        // }

        // for(int i = 0; i< nums.length ; i++) {
        //     nums[i] = queue.poll();
        // }
        
    }
}
