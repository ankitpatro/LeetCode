class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        boolean hasOneZero = true;

    while(hasOneZero) {
        hasOneZero = false;
            for(int i = 1; i < s.length(); i++) {
                if(c[i] == '1' && c[i-1] == '0') {
                    c[i-1] = '1';
                    c[i] = '0';
                    i++;
                    hasOneZero = true;

                }
                
            }
            if(hasOneZero)count++;

            if(!hasOneZero) {
                    break;
                }
         }
         return count;
    }
}
