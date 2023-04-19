class Solution {
    int[] visited;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        visited = new int[nums.length];
        backtrack(nums, result, new ArrayList<Integer>());
        return result;

    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentList) {
        if(currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                continue;
            }

            currentList.add(nums[i]);
            visited[i] = 1;
            backtrack(nums, result, currentList);

            currentList.remove(currentList.size() - 1);
            visited[i] = 0;
        }



    }


}
