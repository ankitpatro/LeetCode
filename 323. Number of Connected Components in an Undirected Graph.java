class Solution {
    public int countComponents(int n, int[][] edges) {

        int components = 0;
        int[] visited = new int[n];
        List<Integer>[] adjacencyList = new ArrayList[n];

        for(int i = 0; i < n; i++)
        {
            adjacencyList[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edges.length; i++)
        {
            adjacencyList[edges[i][0]].add(edges[i][1]);
            adjacencyList[edges[i][1]].add(edges[i][0]); 
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0){
                components++;

                dfs(adjacencyList, visited, i);
            }
        }
        return components;


    }

    private void dfs(List<Integer>[] adjacencyList, int[] visited, int currentNode)
    {
        visited[currentNode] = 1;

        for(int i = 0; i < adjacencyList[currentNode].size(); i++)
        {
            if(visited[adjacencyList[currentNode].get(i)] == 0)
            {
                dfs(adjacencyList, visited, adjacencyList[currentNode].get(i));
            }
        }
    }
}
