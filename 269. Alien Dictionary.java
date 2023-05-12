class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegree.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree.put(word2.charAt(j), inDegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while(!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);

            for(Character next : adjList.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);

                if(inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if(sb.length() != inDegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
