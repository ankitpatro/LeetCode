class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int current, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int result = 0;

        for(int child : adj.get(current)) {
            if(child == parent) {
                continue;
            }

            int time = dfs(child, current, adj, hasApple);
            if(time > 0 || hasApple.get(child)) {
                result = result + time + 2;
            }
        }
        return result;
    }
}
