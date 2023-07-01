class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;
        while(right < nums.length) {
            while(!dq.isEmpty() && nums[right] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(right);

            if(left > dq.peekFirst()) {
                dq.pollFirst();
            }

            if(right - left + 1 >= k) {
                result.add(nums[dq.peekFirst()]);
                left++;
            }

            right++;
        }

        int[] resultArr = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
