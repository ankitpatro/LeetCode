class Solution {
    public int mySqrt(int x) {
        int l = 0; int r = x;
        int res = 0;

        while(l <= r) {
            long m = l + (r - l)/2;
            if(m * m > x) {
                r = (int)m - 1;
            }

            else if(m * m <= x) {
                l = (int)m + 1;
                res = (int)m;
            }

        }

        return res;
    }
}
