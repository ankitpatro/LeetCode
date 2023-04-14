class Solution {
    public String originalDigits(String s) {
        char[] count = new char[26];

        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }

        int[] out = new int[10];

        out[0] = count['z' - 'a'];
        out[2] = count['w' - 'a'];
        out[4] = count['u' - 'a'];
        out[6] = count['x' - 'a'];
        out[8] = count['g' - 'a'];
        
        out[5] = count['f' - 'a'] - out[4];
        out[3] = count['h' - 'a'] - out[8];
        out[7] = count['s' - 'a'] - out[6];
        out[9] = count['i' - 'a'] - out[5] - out[6] - out[8];
        out[1] = count['o' - 'a'] - out[0] - out[2] - out[4];


    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 10; i++){
       for(int j = 0; j < out[i]; j++) {
           sb.append(i);
       }
    }
    return sb.toString();
    }
}
