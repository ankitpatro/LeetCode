class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> combination = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();


        backtrack(0, target, combination, result, candidates);

        return result;

    }

    private void backtrack(int index, int remaining, LinkedList<Integer> combination, List<List<Integer>> result, int[] candidates) {
        if(remaining == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if(remaining  < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            combination.addLast(candidates[i]);
            backtrack(i, remaining - candidates[i], combination, result, candidates);
            combination.removeLast();
        }
    }
}
