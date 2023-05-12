class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        helper(result, new ArrayList<String>(), 0, s);

        return result;
    }

    private void helper(List<List<String>> result, List<String> current, int index, String s) {
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
        }
        for(int j = index; j < s.length(); j++) {
            if(isPalindrome(s, index, j)) {
                current.add(s.substring(index, j + 1));
                helper(result, current, j + 1, s);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
