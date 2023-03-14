class Solution {
    public int countComponents(int n, int[][] edges) {

        int[] ids = new int[n];
        Set<Integer> components = new HashSet<>();

        for(int i = 0; i < n; i++) ids[i] = i;

        for(int i = 0; i < edges.length; i++) union(edges[i][0], edges[i][1], ids);

        for(int i = 0; i < n; i++) components.add(find(i, ids));
           
        return components.size();

        
    }

    private void union(int edge1, int edge2, int[] ids)
    {
        int parent1 = find(ids[edge1], ids);
        int parent2 = find(ids[edge2], ids);

        ids[parent2] = parent1;
    }

    private int find(int edge, int[] ids)
    {
        if(ids[edge] != edge) ids[edge] = find(ids[edge], ids);

        return ids[edge];
    }
}
