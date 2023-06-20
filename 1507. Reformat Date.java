class Solution {
    public String reformatDate(String date) {
        String[] dateFragments = date.split("\\s+");
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        int dd = Integer.valueOf(dateFragments[0].substring(0, dateFragments[0].length() - 2));
        String yyyy = dateFragments[2];

        return yyyy + "-" + monthMap.get(dateFragments[1]) + "-" + String.format("%02d", dd);

    }
}
