class Solution {
    int count;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        for(int i = 0; i < s.length(); i++) {
            expandAroundMiddle(s, i, i);
            expandAroundMiddle(s, i, i + 1);
        }

        return count;
        
    }

    private void expandAroundMiddle(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}
