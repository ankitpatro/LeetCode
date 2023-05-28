/**
To solve this problem, let's look at if s1[0 ~ i] s2[0 ~ j] can be interleaved to s3[0 ~ k].

Start from indices0, 0, 0 and compare s1[i] == s3[k] or s2[j] == s3[k]
Return valid only if either i or j match k and the remaining is also valid
Caching is the key to performance. This is very similar to top down dp
Only need to cache invalid[i][j] since most of the case s1[0 ~ i] and s2[0 ~ j] does not form s3[0 ~ k]. Also tested caching valid[i][j] the run time is also 1ms
Many guys use substring but it's duplicate code since substring itself is checking char by char. We are already doing so
Hope it helps!

 */

class Solution {
    int n1;
    int n2;
    char[] c1;
    char[] c2;
    char[] c3;

    public boolean isInterleave(String s1, String s2, String s3) {
         n1 = s1.length();
         n2 = s2.length();
        int n3 = s3.length();

        if(n1 + n2 != n3) {
            return false;
        }
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();


        int[][] dp = new int[n1 + 1][n2 + 1];

        return dfs(0, 0, dp);
    }

    private boolean dfs(int i, int j, int[][] dp) {
        if(i == n1 && j == n2) {
            return true;
        }

        if(dp[i][j] != 0) {
            return dp[i][j] == 1 ? true : false;
        }

        boolean isValid = 
            i < n1 && c1[i] == c3[i+j] && dfs(i+1, j, dp) ||
            j < n2 && c2[j] == c3[i+j] && dfs(i, j+1, dp);

            dp[i][j] = isValid ? 1 : -1;
            return isValid;
    }
}
