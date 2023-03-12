class Solution {
    public int reverse(int x) {
        int ans = 0;
        int negative = x < 0 ? -1 : 1;
            int val = Math.abs(x);
            while(val > 0)
            {
                int  remainder = val % 10;
                if(ans > (Integer.MAX_VALUE/10) ) return 0;
                ans = (10 * ans) + remainder;
                val /= 10;
            }

            return negative * ans;     
    }
}
