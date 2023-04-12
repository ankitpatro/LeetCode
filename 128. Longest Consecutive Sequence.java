class Solution {
    public int longestConsecutive(int[] nums) {
        
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int count = 0;
                while(set.contains(num++)) {
                    count++;
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
