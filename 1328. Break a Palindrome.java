class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome == null || palindrome.length() == 0 || palindrome.length() == 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        int i = 0;
        int n = palindrome.length();

        while(i < n/2) {
            if(chars[i] - 'a' > 0) {
                chars[i] = 'a';
                return String.valueOf(chars);
            }  
            i++;
        }

        chars[n-1] = 'b';

        return String.valueOf(chars);
    }
}
