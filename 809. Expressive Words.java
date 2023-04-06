class Solution {
    public int expressiveWords(String s, String[] words) {
        int result = 0;
        for(String word : words) {
            if(check(s, word))
                result++;
        }
        return result;

    }

    private boolean check(String s, String word) {

        int i = 0;
        int j = 0;

        while(i < s.length() && j < word.length()) {
            char c1 = s.charAt(i);
            char c2 = word.charAt(j);

            if(c1 != c2)
                return false;
            else {
                int len1 = getLength(i, s);
                int len2 = getLength(j, word);

                if(len1 == len2) {
                    i = i + len1;
                    j = j + len2;
                    continue;
                }
                    
                else if(len2 < len1 && len1 >= 3) {
                    i = i + len1;
                    j = j + len2;
                }

                else {
                    return false;
                }
            }
        }
    return i == s.length() && j == word.length();

    }

    private int getLength(int i, String s) {
        int count = 1;
        i++;

        for( ; i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
}
