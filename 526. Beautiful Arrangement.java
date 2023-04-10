class Solution {
    int count;
    public int countArrangement(int n) {
        if(n == 0) return n;

        int nums[] = new int[n+1];
        for(int i = 0; i <=n; i++) {
            nums[i] = i;
        }

        backtrack(nums, n);
        return count;
    }

    private void backtrack(int[] nums, int index) {
        if(index == 0) {
            count++;
            return;
        }

        for(int i = index; i > 0; i--) {
            swap(nums, i, index);

            if(nums[index] % index == 0 || index % nums[index] == 0) {
                backtrack(nums, index - 1);
            }

            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
