class Solution {
    int start;
    int length;
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() < 2) return s;

        for(int i = 0; i < s.length() - 1; i++)
        {
            expandAroundMiddle(s, i, i);
            expandAroundMiddle(s, i, i + 1);
        }

        return s.substring(start, start + length);

    }

    private void expandAroundMiddle(String s, int i, int j)
    {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }

        i++; j--;

        if(length < j - i + 1)
        {
            length = j - i + 1;
            start  = i;
        }
    }
}
