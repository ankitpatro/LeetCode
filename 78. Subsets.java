class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, new ArrayList<Integer>(), result, nums);

        return result;
    }

    private void backtrack(int index, List<Integer> currentList, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(currentList));

        for(int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            backtrack(i+1, currentList, result, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}
