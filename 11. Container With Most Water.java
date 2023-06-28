class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2) return 0;
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while(i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);
            maxArea = Math.max(area, maxArea);

            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}
