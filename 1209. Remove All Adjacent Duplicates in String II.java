class Solution {
    class Pair {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0) return s;
        Stack<Pair> stack = new Stack();

        for(char c : s.toCharArray()) {
            
            if(!stack.isEmpty() && c == stack.peek().c) {
                Pair pair = stack.peek();
                 pair.count = pair.count + 1;

                 if(pair.count == k) {
                    stack.pop();
                }
            }

            else {
                stack.push(new Pair(c, 1));
            }

            
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            for(int i = 0; i < pair.count; i++) {
                result.append(String.valueOf(pair.c));
            }
        }
        return result.reverse().toString();
    }
}
