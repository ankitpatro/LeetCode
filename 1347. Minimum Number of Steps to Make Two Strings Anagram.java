class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> charToCount = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            charToCount.put(s.charAt(i), charToCount.getOrDefault(s.charAt(i), 0) + 1);
            charToCount.put(t.charAt(i), charToCount.getOrDefault(t.charAt(i), 0) - 1);
        }

        int minCount = 0;
        for(Map.Entry<Character, Integer> entry : charToCount.entrySet()) {
            if(entry.getValue() > 0) {
                minCount += entry.getValue();
            }
        }
        return minCount;
    }
}
