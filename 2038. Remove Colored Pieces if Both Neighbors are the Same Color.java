class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();

        int a = 0;
        int b = 0;
        char[] col = colors.toCharArray();

        for(int  i = 0; i < n - 2; i++) {
            if(col[i] == 'A' && col[i + 1] == 'A' && col[i + 2] == 'A') {
                a++;
            }

            if(col[i] == 'B' && col[i + 1] == 'B' && col[i + 2] == 'B') {
                b++;
            }
        }

        return a > b;
    }
}
