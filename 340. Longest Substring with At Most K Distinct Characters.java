class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        Map<Character, Integer> characterToFrequency = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < s.length()) {
            characterToFrequency.put(s.charAt(right), characterToFrequency.getOrDefault(s.charAt(right), 0) + 1);
            right++;

            while(characterToFrequency.size() > k) {
                if(characterToFrequency.get(s.charAt(left)) == 1) {
                    characterToFrequency.remove(s.charAt(left));
                }

                else {
                    characterToFrequency.put(s.charAt(left), characterToFrequency.get(s.charAt(left)) - 1);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
