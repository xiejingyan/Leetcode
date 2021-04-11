package leetcode;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class _468_validIPAddress {
    public String validIPAddress(String IP) {
        if (IP.length() < 15) {
            return ip4(IP);
        }
        else if (IP.length() > 15) {
            return ip6(IP);
        }
        else {
            if (IP.charAt(1) == ':') {
                return ip6(IP);
            }
            else {
                return ip4(IP);
            }
        }
    }
    public String ip4(String ip) {
        String k = "0123456789";
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < k.length(); i++) {
            list.add(k.charAt(i));
        }
        String[] strings = ip.split("\\.");
        if (strings.length != 4 || ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return "Neither";
        }
        for (int i = 0; i < 4; i++) {
            if (strings[i].length() == 0) {
                return "Neither";
            }
            for (int j = 0; j < strings[i].length(); j++) {
                if (!list.contains(strings[i].charAt(j))) {
                    return "Neither";
                }
            }
            int num = Integer.parseInt(strings[i]);
            if (num > 255 || num < 0) {
                return "Neither";
            }
            if (num > 0 && strings[i].charAt(0) == '0') {
                return "Neither";
            }
            if (num == 0 && strings[i].length() > 1) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    public String ip6(String ip) {
        String k = "0123456789abcdefABCDEF";
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < k.length(); i++) {
            list.add(k.charAt(i));
        }
        String[] strings = ip.split(":");
        if (strings.length != 8 || ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return "Neither";
        }
        for (int i = 0; i < 8; i++) {
            if (strings[i].length() > 4 || strings[i].length() == 0) {
                return "Neither";
            }
            for (int j = 0; j < strings[i].length(); j++) {
                if (!list.contains(strings[i].charAt(j))) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

//    try/catch
    public String validIPAddress1(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "Neither";
    }

//    正则表达式
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + ":){7}" + chunkIPv6 + "$");
    public String validIPAddress2(String IP) {
        if (IP.contains(".")) {
            return (pattenIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
        }
        else if (IP.contains(":")) {
            return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

//    分治法
    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) return "Neither";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (! Character.isDigit(ch)) return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
    }
    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
    public String validIPAddress3(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        }
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        }
        else return "Neither";
    }
}
