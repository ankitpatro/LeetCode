class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = heights.length - 1;
        stack.push(i--);
        
        while(i >= 0) {
            if(heights[stack.peek()] < heights[i]) {
                stack.push(i);
            }

            i--;
        }

        int[] result = new int[stack.size()];
        int j = 0;
        while(!stack.isEmpty()) {
            result[j++] = stack.pop();
        }
        return result;
    }
}
