class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), result, 0);

        return result;
    }

    private void dfs(int[] candidates, int remaining, List<Integer> currentList, List<List<Integer>> result, int index) {
        if(remaining == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if(remaining < 0) {
            return;
        }

        if(index >= candidates.length) {
            return;
        }

        

        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }

            if(candidates[i] > remaining)
            {
                break;
            }

            currentList.add(candidates[i]);
            dfs(candidates, remaining - candidates[i], currentList, result, i+1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
