class Solution {
    
    Stack<Integer> stack;
    ArrayList<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        graph = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        
        for(int i = 0; i<numCourses; i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<prerequisites.length; i++)
        {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        stack = new Stack<Integer>();
        
        for(int i = 0 ; i < numCourses; i++)
        {
            if(!visited[i])
            {
                if(isCyclic(i))
                {
                    return new int[]{};
                }
            }            
        }
        
        visited = new boolean[numCourses];
        
        for(int i = 0; i < numCourses ; i++)
        {
            if(!visited[i])
            {
                topologicalSort(i);
            }
        }
        
        int[] order = new int[stack.size()];
        for(int i = 0 ; i < order.length; i++)
        {
            order[i] = stack.pop();
        }
        
        return order;
    }
    
    
    
    private boolean isCyclic(int i)
    {
        visited[i] = true;
        for(Integer j : graph[i])
        {
            if(!visited[j])
            {
                if(isCyclic(j))
                {
                    return true;
                }
                    
            }
            
            else if(!explored[j])
            {
                return true;
            }
            
        }
        
        explored[i] = true;
        return false;
    }
    
    private void topologicalSort(int i)
    {
        visited[i] = true;
        for(Integer j : graph[i])
        {
            if(!visited[j])
            {
                topologicalSort(j);
            }
        }
        
        stack.push(i);
    }
}
