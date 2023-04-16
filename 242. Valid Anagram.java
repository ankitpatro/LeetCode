class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] letterCount = new int[128];
        for(char c : s.toCharArray()) {
            ++letterCount[c];
        }

        int count = 0;
        for(char c : t.toCharArray()) {
            if(letterCount[c] > 0) {
                --letterCount[c];
                count++;
            }
        }
        return count == t.length();
    }
}
