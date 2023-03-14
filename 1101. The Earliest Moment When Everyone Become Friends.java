class Solution {
    public int earliestAcq(int[][] logs, int n) {

        //Sort as per the non-decreasing timestamp;
        Arrays.sort(logs, (a,b) ->{
            return a[0] - b[0];
        });

        int[] ids = new int[n];
        int groupSize = n;
        for(int i = 0; i < n; i++)
        {
            ids[i] = i;
        }

        for(int i = 0; i < logs.length; i++)
        {
            groupSize -= union(logs[i][1], logs[i][2], ids);
            if(groupSize == 1) return logs[i][0];
        }

        return -1;
        
    }

    //merge 2 groups and return change in number of groups
    private int union(int edge1, int edge2, int[] ids)
    {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);

        if(parent1 == parent2) return 0;
        ids[parent1] = parent2;
        return 1;
    }

    private int find(int edge, int[] ids)
    {
        if(ids[edge] != edge) ids[edge] = find(ids[edge], ids);
        return ids[edge];
    }
}
