class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int n1 = arr1.length;
        int n2 = arr2.length;

        int len = Math.max(n1, n2);

        for(int i = 0; i < len; i++) {
            int v1 = i < n1 ? Integer.parseInt(arr1[i]) : 0;
            int v2 = i < n2 ? Integer.parseInt(arr2[i]) : 0;

            if(v1 < v2) {
                return -1;
            }

            else if(v2 < v1) {
                return 1;
            }
        }
        return 0;
    }
}
