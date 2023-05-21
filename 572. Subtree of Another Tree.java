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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) {
            return false;
        }
        
        if(isSameTree(root, subRoot)) {
            return true;
        }

        else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null || t == null) {
            return s == null && t == null;
        }

        if(s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }

        return false;
    }
}
