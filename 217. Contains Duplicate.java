class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
          //{set.add() -> returns false if the element is already present in the set}
            if(!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}
