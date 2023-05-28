class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            int numOf1 = count1(num);
            map.put(num, numOf1); 
        }
        Integer[] result = new Integer[arr.length];
        Arrays.setAll(result, i -> arr[i]);

        Arrays.sort(result, (a, b) -> {
             int count1 = map.get(a);
             int count2 = map.get(b);
             if(count1 == count2) {
                 return a - b;
             }

             return count1 - count2;
        });
        Arrays.setAll(arr, i -> result[i]);
        return arr;
    }

    private int count1(int num) {
        int count = 0;
        while(num != 0) {
            count += num & 1;
           num =  num >> 1;

        }

        return count;
    }
}
