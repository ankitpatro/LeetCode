class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(new ArrayList<Integer>(),n, k, result, 1);

        return result;
    }

    private void backtrack(List<Integer> currentList, int n, int k, List<List<Integer>> result, int index) {
        if(currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
        }

        for(int i = index; i <= n; i++) {
            currentList.add(i);
            backtrack(currentList, n, k, result, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
