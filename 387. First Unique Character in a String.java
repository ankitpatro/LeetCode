class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] characters = s.toCharArray();
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for(int i = 0; i < characters.length; i++) {
            if(count[characters[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
