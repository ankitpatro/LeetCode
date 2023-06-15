class Solution {
    public int smallestCommonElement(int[][] mat) {
        if(mat.length == 0) {
            return -1;
        }

        int col = mat[0].length;
        int row = mat.length;
        for(int i = 0; i < col; i++) {
            int freq = 1;
            int num = mat[0][i];

            for(int j = 1; j < row; j++) {
                if(isNumPresent(mat[j], num)) {
                    freq++;
                }

                else {
                    break;
                }
            }

            if(freq == row) {
                return num;
            }

        }

        return -1;
    }

    private boolean isNumPresent(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1; 
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(num == arr[mid]) {
                return true;
            }

            else if(num < arr[mid]) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
