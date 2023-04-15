class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {

            if((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                result.add("FizzBuzz");
                continue;
            }

             else if((i + 1) % 3 == 0) {
                 result.add("Fizz");
                 continue;
            }
            
            else if((i + 1) % 5 == 0) {
                result.add("Buzz");
                continue;
            }

            else {
                result.add(String.valueOf(i+1));
            }
            


        }

        return result;
    }
}
