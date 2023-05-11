class Solution {
  public String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1;
    if (i < j) return addBinary(b, a);

    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while(i > -1) {
      if (a.charAt(i--) == '1') ++carry;
      if (j > -1 && b.charAt(j--) == '1') ++carry;

      if (carry % 2 == 1) sb.append('1');
      else sb.append('0');

      carry /= 2;
    }
    if (carry == 1) sb.append('1');
    sb.reverse();

    return sb.toString();
  }
}
