class Solution {

        boolean[] visited;
        int visitedCount = 0;

    public boolean validTree(int n, int[][] edges) {
        visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int edge1 = edge[0];
            int edge2 = edge[1];

            adj.get(edge1).add(edge2);
            adj.get(edge2).add(edge1);
        }

        return dfs(0, -1, adj) && visitedCount == n;
    }

    private boolean dfs(int current, int parent, List<List<Integer>> adj) {
        if(visited[current]) {
            return false;
        }

        visited[current] = true;
        visitedCount++;

        for(int edge : adj.get(current)) {
            if(edge == parent) {
                continue;
            }

            if(!dfs(edge, current, adj)) return false;
        }
        return true;

    }
}
