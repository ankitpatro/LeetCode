class FreqStack {

    Map<Integer, Integer> numToFrequency;
    Map<Integer, Stack<Integer>> freqToStack;
    int maxFreq;

    public FreqStack() {
        numToFrequency = new HashMap<>();
        freqToStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int newFreq = numToFrequency.getOrDefault(val, 0) + 1;
        numToFrequency.put(val, newFreq);

        maxFreq = Math.max(maxFreq, newFreq);

        if(freqToStack.get(newFreq) == null) {
            freqToStack.put(newFreq, new Stack<>());
        }

        freqToStack.get(newFreq).push(val);

    }
    
    public int pop() {
        Stack<Integer> frequentNums = freqToStack.get(maxFreq);
        int result = frequentNums.pop();
        numToFrequency.put(result, numToFrequency.get(result) - 1);
        if(frequentNums.isEmpty()) {
            maxFreq--;
        }

        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
