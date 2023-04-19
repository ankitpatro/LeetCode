class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Set<Integer>> preferredMap = new HashMap<>();

        for(int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];

            Set<Integer> xPreferenceSet = getPreferences(preferences[x], y);
            Set<Integer> yPreferenceSet = getPreferences(preferences[y], x);
            preferredMap.put(x, xPreferenceSet);
            preferredMap.put(y, yPreferenceSet);

        }
        int result = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : preferredMap.entrySet()) {
            Set<Integer> xSet = entry.getValue();
            for(int y : xSet) {
                if(preferredMap.get(y).contains(entry.getKey())) {
                    result++;
                    break;
                }
            }
        }
        return result;

    }

    private Set<Integer> getPreferences(int[] preferences, int pairWith) {
        Set<Integer> set = new HashSet<>();
        for(int pref : preferences) {
            if(pref == pairWith) {
                return set;
            }
            set.add(pref);
        }
        return set;
    }


}
