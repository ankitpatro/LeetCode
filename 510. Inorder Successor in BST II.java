/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        
        //Case 1: Successor is present in right subtree
        // find the leftmost node in right subtree
        if(node.right != null) {
            Node right = node.right;
            while(right.left != null) {
                right = right.left;
            }

            return right;
        }

        //Successor is present in one of the parents
        //Traverse trough parents in the tree until parent.val > node.val
        Node parent = node.parent;
        
        while(parent != null ) {
            if(parent.val > node.val) {
                return parent;
            }
            else {
                parent = parent.parent;
            }
        }

        return null;
        }



       

    }
