class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int[] seen = new int[60];
        int count = 0;
        for(int t : time) {
            int remaining  = (60 - (t % 60)) % 60;

            count += seen[remaining];
            seen[t % 60]++;
        }

        return count;
    }
}
