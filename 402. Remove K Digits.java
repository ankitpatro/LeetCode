class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(char digit : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                k--;
                stack.pop();
            }
            stack.push(digit);
        }

        for(int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder result= new StringBuilder();

        boolean leadingZero = true;

        for(char digit : stack) {
            if(leadingZero && digit =='0') {
                continue;
            }
            leadingZero = false;
            result.append(digit);
        }

        if(result.length() == 0) return "0";
        return result.toString();
    }
}
