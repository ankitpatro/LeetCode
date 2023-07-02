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
    TreeNode first;
    TreeNode middle;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        
        inorder(root);

     if(second!= null) swap(first, second);
     else swap(first, middle);


    }

    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
                middle = root;
            }
            else {
                second = root;
            }
            
        }
        prev = root;

        inorder(root.right);
    }
}
