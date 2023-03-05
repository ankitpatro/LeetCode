class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> charToValue = new HashMap<>();
        charToValue.put('I', 1);
        charToValue.put('V', 5);
        charToValue.put('X', 10);
        charToValue.put('L', 50);
        charToValue.put('C', 100);
        charToValue.put('D', 500);
        charToValue.put('M', 1000);

        int result = 0;

        for(int i = 0; i< s.length() ; i++)
        {
            if(i >0)
            {
                if( ((s.charAt(i) == 'V' ||s.charAt(i) == 'X') && (s.charAt(i-1) == 'I' )) ||
                ((s.charAt(i) == 'L' ||s.charAt(i) == 'C') && (s.charAt(i-1) == 'X' )) ||
                ((s.charAt(i) == 'D' ||s.charAt(i) == 'M') && (s.charAt(i-1) == 'C' )))
                {
                    result += charToValue.get(s.charAt(i)) - (2* charToValue.get(s.charAt(i-1)));
                    continue;
                }

            }

            result += charToValue.get(s.charAt(i));
            
        }

        return result;
    }

//MCMXCIV = 10000 +100 + 1000 - 200 +10 + 100 -20 +1 + 5 -2

}
