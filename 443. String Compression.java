class Solution {
    public int compress(char[] chars) {
        
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chars.length; i++) {
            if(i+1 < chars.length && chars[i+1] == chars[i]) {
                count++;
                continue;
            }

            if(count > 1) {
                sb.append(chars[i]);
                sb.append(count);
            }

            else {
                sb.append(chars[i]);
            }

            count = 1;
        }

        for(int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
