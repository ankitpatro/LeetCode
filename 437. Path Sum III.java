class Solution {
    int count = 0;
    int k;
    HashMap<Long, Integer> prefixSumToCount = new HashMap();    
            
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }

    private void preorder(TreeNode node, long prevSum) {
        if (node == null)
            return;
        
        // current prefix sum
        long currSum = node.val + prevSum;

        // here is the sum we're looking for
        if (currSum == k)
            count++;
        
        // number of times the curr_sum − k has occured already, 
        // determines the number of times a path with sum k 
        // has occured upto the current node
        count += prefixSumToCount.getOrDefault(currSum - k, 0);
        
        // add the current sum into hashmap
        // to use it during the child nodes processing
        prefixSumToCount.put(currSum, prefixSumToCount.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        prefixSumToCount.put(currSum, prefixSumToCount.get(currSum) - 1);
    }
}
