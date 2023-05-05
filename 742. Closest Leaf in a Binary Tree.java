/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        for(TreeNode node : graph.keySet()) {
            if(node != null && node.val == k) {
                queue.offer(node);
                seen.add(node);
            }
        }

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node != null) {
                if(graph.get(node).size() == 1) {
                    return node.val;
                }

                for(TreeNode neighbourNode : graph.get(node)) {
                    if(!seen.contains(neighbourNode)) {
                        queue.offer(neighbourNode);
                        seen.add(neighbourNode);
                    }
                }
            }
        }
        throw null;
    }

    private void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {

        if(node != null) {
            if(!graph.containsKey(node)) {
                graph.put(node, new ArrayList<>());
            }

            if(!graph.containsKey(parent)) {
                graph.put(parent, new ArrayList<>());
            }

            graph.get(node).add(parent);
            graph.get(parent).add(node);

            dfs(graph, node.left, node);
            dfs(graph, node.right, node);
        }
    }
}
