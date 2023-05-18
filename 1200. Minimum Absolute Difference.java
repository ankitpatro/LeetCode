class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        int lowestDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            int currDiff = arr[i] - arr[i-1];
            if(currDiff == lowestDiff) {
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }

            else if(currDiff > lowestDiff) {
                continue;
            }

            else {
                result.clear();
                result.add(Arrays.asList(arr[i-1], arr[i]));
                lowestDiff = currDiff;
            }
        }

        return result;
    }
}
