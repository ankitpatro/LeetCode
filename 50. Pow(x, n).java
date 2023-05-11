class Solution {
    public double myPow(double x, int n) {

//  --------------------USING RECURRSION--------------------------       
        double result =  helper(x, Math.abs(n));

        return n > 0 ? result : 1 / result;
    }

    private double helper(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        double res = helper(x, n / 2);
        res = res * res;
        return n % 2 == 0 ? res : x * res;
    }

    // ------------------304 / 305 test cases--------------------------
    // if(x == 0) return 0;

    // if(n < 0) {
    //     x = 1/x;
    //     n = 0 - n;
    // }
    // double result = 1;

    // while(n > 0) {
    //     if(n % 2 == 0) {
    //         x = x * x;
    //         n = n/2;
    //     }

    //     else {
    //         result = result * x;
    //         n--;
    //     }
    // }
    // return result / 1;

    // }
}
