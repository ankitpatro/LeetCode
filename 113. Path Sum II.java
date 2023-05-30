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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        dfs(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> currentList) {
        if(node == null) {
            return;
        }

        currentList.add(node.val);

        targetSum = targetSum - node.val;

        if(targetSum == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentList));
        }

        dfs(node.left, targetSum, result, currentList);
        
        dfs(node.right, targetSum, result, currentList);
        currentList.remove(currentList.size() - 1);
    }
}
