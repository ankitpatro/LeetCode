class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            dfs(n, k, 0, result, i, i);
        }
        
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void dfs(int n, int k, int index, List<Integer> result, int currentNum, int currentDigit) {
        if(index == n-1) {
            result.add(currentNum);
            return;
        }

        int next = currentDigit + k;
        if(next < 10 && k != 0) {
            dfs(n, k, index + 1, result, currentNum * 10 + next, next);
        }

        next = currentDigit - k;

        if(next >= 0) {
            dfs(n, k, index + 1, result, currentNum * 10 + next, next);
        }
    }
}
