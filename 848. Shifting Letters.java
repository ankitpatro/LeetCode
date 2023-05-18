class Solution {
    public String shiftingLetters(String s, int[] shifts) {
      StringBuilder sb = new StringBuilder(s);

      int shift = 0;

      for(int i = shifts.length - 1; i >= 0; i--) {
          shift += shifts[i] % 26;
          shift %= 26;

          sb.setCharAt(i,(char)(((s.charAt(i)-'a')+shift)%26+'a'));
      }
      return sb.toString();
    }
}
