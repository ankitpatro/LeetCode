class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int diff = 0;
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];

        for(char c : word1.toCharArray()) {
            chars1[c - 'a']++;
        }
        
        for(char c : word2.toCharArray()) {
            chars2[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            diff = Math.abs(chars1[i] - chars2[i]);
            if(diff > 3) {
                return false;
            }
            
        }

        return true;
    }
}
