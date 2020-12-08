package leetcode;

public class _925_isLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        else {
            int i = 0;
            int j = 0;
            while (i < name.length() && j < typed.length()) {
                if (name.charAt(i) == typed.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (i == 0) return false;
                    else if (typed.charAt(j - 1) == typed.charAt(j)) j++;
                    else return false;
                }
            }
            if (i == name.length() && j < typed.length()) {
                while (j < typed.length()) {
                    if (name.charAt(i - 1) == typed.charAt(j)) j++;
                    else return false;
                }
                return true;
            }
            else return i == name.length() && j == typed.length();
        }
    }

    public boolean isLongPressedName2(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
