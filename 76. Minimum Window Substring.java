class Solution {
    public String minWindow(String s, String t) {
        
        if(s == null || t == null) {
            return  null;
        }

        String result = "";
        int left = 0;
        int count = 0;
        int minLen = s.length() + 1;
        int[] charCount = new int[128];

        for(char c : t.toCharArray()) {
            charCount[c]++;
        }

        for(int right = 0; right < s.length(); right++) {
            if(--charCount[s.charAt(right)] >= 0 ) {
                count++;
            }

            while(count == t.length()) {
                if(minLen > right - left + 1) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                if(++charCount[s.charAt(left)] > 0) {
                    count--;
                }

                left++;
            }
        }

        return result;
    }
}
