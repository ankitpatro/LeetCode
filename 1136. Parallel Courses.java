class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        int[] inCount = new int[n + 1]; //in-degree(number of dependencies)

        List<List<Integer>> graph = new ArrayList<>(); //adjacency list

        for(int i = 0; i < n + 1; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] relation : relations)
        {
            graph.get(relation[0]).add(relation[1]);
            inCount[relation[1]]++;
        }

        int steps = 0;
        int studiedCount = 0;

        List<Integer> queue = new ArrayList<>();
        for(int i = 1; i < n + 1; i++) {
            if(inCount[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            steps++;
            List<Integer> nextQueue = new ArrayList<>();
            for(int node : queue)
            {
                studiedCount++;
                for(int nextNode : graph.get(node))
                {
                    inCount[nextNode]--;
                    if(inCount[nextNode] == 0)
                    nextQueue.add(nextNode);
                }
            }

            queue = nextQueue;
        }

        return studiedCount == n ? steps : -1;
    }
}
