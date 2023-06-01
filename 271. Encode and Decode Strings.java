public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            int size = str.length();
            sb.append(size).append("#").append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;

        List<String> result = new ArrayList<>();
        while(i < s.length()) {
            int j = i;
            while(s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.valueOf(s.substring(i, j));
            result.add(s.substring(j+1, j + 1 + len));
            i = j + len + 1;
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
