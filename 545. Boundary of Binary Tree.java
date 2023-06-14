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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);

        leftBoundaryNodes(root.left, result);

        if(root.left != null || root.right != null)
        leafNodes(root, result);
        rightBoundaryNodes(root.right, result);

        return result;
    }

    private void leftBoundaryNodes(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            result.add(root.val);
            leftBoundaryNodes(root.left, result);
        }

        else if(root.right != null) {
            result.add(root.val);
            leftBoundaryNodes(root.right, result);
        }
    }

    private void leafNodes(TreeNode root, List<Integer> result) {
        if(root.left == null && root.right == null) {
            result.add(root.val);
        }

         if(root.left != null) {
            leafNodes(root.left, result);
        }

         if(root.right != null) {
            leafNodes(root.right, result);
        }
 
    }

    private void rightBoundaryNodes(TreeNode root, List<Integer> result) {

        if(root == null) {
            return;
        }

        if(root.right!= null) {
            rightBoundaryNodes(root.right, result);
            result.add(root.val);
        }

        else if(root.left != null) {
            rightBoundaryNodes(root.left, result);
            result.add(root.val);
        }
    }
}
