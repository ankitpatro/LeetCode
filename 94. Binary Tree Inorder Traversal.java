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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;


        }

        return result;
    }

//------------------- Iterative Solution -----------------



// ------------------ Recursive Solution -----------------
/**
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
        
    }

    private void helper(List<Integer> result, TreeNode root) {
        if(root == null) return;
        
        helper(result, root.left);
        result.add(root.val);
        helper(result, root.right);
    }

     */
}
