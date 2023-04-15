public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int result = 0;

        // ****************Iterate Over 32 Times**********************
        // int mask = 1;
        // for(int i = 0; i < 32; i++) {
        //     if((n & mask) != 0) {
        //         result++;
        //     }
        //     mask = mask << 1;
        // }
        // return result;
        // ***********************************************************

// ***************** AND with n-1 to remove 1 at each step******************

        while(n != 0) {
            n = n & (n-1);
            result++;
        }

        return result;

//****************************************************************************** */ 

    }
}
