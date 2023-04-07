class Solution {
    public String validIPAddress(String queryIP) {
        
        if(queryIP == null || queryIP.length() == 0)
            return "Neither";

        if(queryIP.contains(".")) {
            return checkIPv4(queryIP);
        }

        else if(queryIP.contains(":")) {
            return checkIPv6(queryIP);
        }

        else {
            return "Neither";
        }

    }

    private String checkIPv4(String ip) {
        String n = "Neither";
        String[] cells = ip.split("\\.");

        if(ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return n;
        }

        if(cells.length != 4) {
            return n;
        }

        for(String cell : cells) {
            if(cell.length() > 3 || cell.length() == 0 || cell.charAt(0) == '0' && cell.length() >1) {
                return n;
            }

            for(char c : cell.toCharArray()) {
                if(!Character.isDigit(c)) {
                    return n;
                }
            }

            if(Integer.parseInt(cell) > 255) {
                return n;
            }
        }

        return "IPv4";
    }

    private String checkIPv6(String ip) {
        String n = "Neither";
        String[] cells = ip.split(":");
        String hexdigits = "0123456789abcdefABCDEF";

        if(cells.length != 8) return n;

        if(ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return n;
        }

        for(String cell : cells) {
            if(cell.length() > 4 || cell.length() == 0) return n;

            for(char c : cell.toCharArray()) {
                if(hexdigits.indexOf(c) == -1) return n;
            }

        }
        return "IPv6";
    }
}
