package Leetcode;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {

        int i = 0;
        int j = A.length - 1;
        int k = j;

        int[] ans = new int[j + 1];

        while (i <= j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                ans[k--] = A[i] * A[i];
                i++;
            } else {
                ans[k--] = A[j] * A[j];
                j--;
            }
        }
        return ans;
    }
}

