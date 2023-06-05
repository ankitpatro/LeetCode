class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i =0; i <= n; i++) {
            result[i] = count1Bits(i);
        }

        return result;
    }

    private int count1Bits(int num) {
        int count = 0;

        while(num > 0) {
            // if((num & 1) == 1) {
            //     count++;
            // }
            // num = num >> 1;

            num = (num & (num - 1));
            count++;
        }

        return count;
    }
}
