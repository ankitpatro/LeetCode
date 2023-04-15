class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;

        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        while(i <= j) {
            if(i == j ) {
                result++;
                break;
            }
            if(people[j] + people[i] > limit) {
                j --;
                result++;
                continue;
            }

            if(people[i] + people[j] <= limit) {
                result++;
                i++;
                j--;
            }

            
        }
        return result;
    }
}
