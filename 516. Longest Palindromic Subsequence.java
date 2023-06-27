class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >=0; i-- ) {
            sb.append(String.valueOf(s.charAt(i)));
        }

        String s2 = sb.toString();

        int n = s.length();
        int[][] dp =new int[n + 1][n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(s.charAt(i) ==s2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                }

                else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[n][n];
    }
}
