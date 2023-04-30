/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {

        String nodeVal = queue.poll();

        if(nodeVal.equals("null")) {
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.valueOf(nodeVal));
        treeNode.left = buildTree(queue);
        treeNode.right = buildTree(queue);

        return treeNode;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
