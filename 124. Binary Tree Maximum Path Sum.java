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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return max;
        
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        //split to compute max including, left, right and root 
        max = Math.max(max, left + right + root.val);

        //without split: choose either left or right
        return root.val + Math.max(left, right);
    }
}
