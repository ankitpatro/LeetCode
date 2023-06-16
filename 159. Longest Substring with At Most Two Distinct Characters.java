class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0;
        // int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int j = 0; j < s.length(); j++) {
            char jCharacter  = s.charAt(j);
             map.put(jCharacter, map.getOrDefault(jCharacter, 0) + 1);
       
                  while(map.size() > 2) {
                      char iCharacter = s.charAt(i);
                      map.put(iCharacter, map.get(iCharacter) - 1);
                      if(map.get(iCharacter) == 0) {
                          map.remove(iCharacter);
                      }
                      i++;
                  }
              max = Math.max(max, j - i + 1);
            }
        
        return max;
    }
}
