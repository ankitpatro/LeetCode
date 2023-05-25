/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0) {
            return List.of(target.val);
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        adj.put(-1, new ArrayList<>());
        createAdjacency(-1, root, adj);

        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(target.val);
        while(!queue.isEmpty()) {
            if(k == 0) {
                return queue;
            }
            k--;
            int size = queue.size();
            for(int i = 0; i < size; i++) {

            
            int current = queue.poll();
            visited.add(current);
            for(int neighbor : adj.get(current)) {
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
            }
   
        }
         return queue;
    }

    private void createAdjacency(int parent, TreeNode current, Map<Integer, List<Integer>> adj) {
        if(current == null) {
            return;
        }
        if(!adj.containsKey(current.val)) {
            adj.put(current.val, new ArrayList<Integer>());
        }

        if(parent != -1)
        adj.get(current.val).add(parent);

        if(current.left != null) {
            adj.get(current.val).add(current.left.val);
            createAdjacency(current.val, current.left, adj);
        }

        if(current.right != null) {
            adj.get(current.val).add(current.right.val);
            createAdjacency(current.val, current.right, adj);
        }

    }
}
