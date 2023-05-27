class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> domianToCount = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                domianToCount.put(cur, domianToCount.getOrDefault(cur, 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : domianToCount.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
