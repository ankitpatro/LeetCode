class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = ("" + n).toCharArray();

        int i = digits.length - 2;
        while(i >= 0 && digits[i+1] <= digits[i]) {
            i--;
        }

        if(i < 0) {
            return -1;
        }

        int j = digits.length - 1;
        while(j >= 0 && digits[j] <= digits[i]) {
            j--;
        }

        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        int result = 0;

        try {
            result = Integer.parseInt(String.valueOf(digits));
        }

        catch(Exception e) {
            return -1;
        }
        return result;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int i, int j) {
        while(i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }

}
