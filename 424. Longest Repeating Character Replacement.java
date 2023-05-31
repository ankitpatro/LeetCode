class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int start = 0;
        int end = 0;

        int maxCount = 0;
        int[] charCount = new int[26];
        int maxLength = 0;

        while(end < n) {
            charCount[s.charAt(end)-'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(end)- 'A']);

            while(end - start + 1 - maxCount > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}
