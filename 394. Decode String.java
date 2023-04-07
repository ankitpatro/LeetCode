class Solution {
    public String decodeString(String s) {
        
        StringBuilder currentWord = new StringBuilder();
        int num = 0;
        Stack<String> wordStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            else if(Character.isLetter(s.charAt(i))) {
                currentWord.append(s.charAt(i));
            }

            else if(s.charAt(i) == '[') {
                numStack.push(num);
                wordStack.push(currentWord.toString());
                num = 0;
                currentWord = new StringBuilder();
            }

            else {
                int number = numStack.pop();
                StringBuilder poppedWord = new StringBuilder(wordStack.pop());

                for(int k = 0; k < number; k++) {
                    poppedWord.append(currentWord);
                }

                currentWord = poppedWord;
            }
        }

        return currentWord.toString();
    }
}
