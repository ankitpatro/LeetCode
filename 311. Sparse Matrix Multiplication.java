class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;

        int[][] result = new int[n][m];
        for(int row = 0; row < n; row++) {
            for(int elementIndex = 0; elementIndex < k; elementIndex++) {
                if(mat1[row][elementIndex] != 0) {
                for(int col = 0; col < m; col++) {
                    result[row][col] += mat1[row][elementIndex] * mat2[elementIndex][col];
                }
            }
        }
    }
        return result;
    }
}
