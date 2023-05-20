class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for(int[] edge : prerequisites) {
            adjacencyList.get(edge[1]).add(edge[0]);
            indegrees[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) queue.offer(i);
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            for(int neighbour : adjacencyList.get(currentNode)) {
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0) queue.offer(neighbour);

            }
        }

        for(int i : indegrees) {
            if(i != 0) return false;
        }

        return true;
    }
}
