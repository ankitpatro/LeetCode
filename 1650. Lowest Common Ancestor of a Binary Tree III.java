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
    public Node lowestCommonAncestor(Node p, Node q) {
        /**
--------Using 1 HashSet--------------------------------
         */
        Set<Node> pParentSet = new HashSet<>();

        while(p != null) {
            pParentSet.add(p);
            p = p.parent;
        }

        while(q != null) {
            if(pParentSet.contains(q)) {
                return q;
            }

            q = q.parent;
        }

    return null;



        /**
--------Using 2 Stacks---------------------------------
         */

        // Stack<Node> stack1 = new Stack();
        // Stack<Node> stack2 = new Stack();

        // while(p!= null) {
        //     stack1.push(p);
        //     p = p.parent;
            
        // }

        // while(q!= null) {
        //     stack2.push(q);
        //     q = q.parent;
            
        // }
        // Node ancestor = null;

        // while(!stack1.isEmpty() && !stack2.isEmpty()) {
        //     if(stack1.peek() == stack2.peek()) {
        //         ancestor = stack1.peek();
        //     }
        //     stack1.pop();
        //     stack2.pop();
        // }

        // return ancestor;
        

    }
}
