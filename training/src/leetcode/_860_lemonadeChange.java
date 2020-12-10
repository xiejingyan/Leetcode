package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _860_lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> nums = new HashMap<>();
        nums.put(5, 0);
        nums.put(10, 0);
        for (int bill : bills) {
            if (bill == 10) {
                if (nums.get(5) > 0) {
                    nums.put(5, nums.get(5) - 1);
                    nums.put(10, nums.get(10) + 1);
                }
                else {
                    return false;
                }
            }
            else if (bill == 5) {
                nums.put(5, nums.get(5) + 1);
            }
            else {
                if (nums.get(5) > 0) {
                    if (nums.get(10) > 0) {
                        nums.put(5, nums.get(5) - 1);
                        nums.put(10, nums.get(10) - 1);
                    }
                    else {
                        if (nums.get(5) >= 3) {
                            nums.put(5, nums.get(5) - 3);
                        }
                        else {
                            return false;
                        }
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _860_lemonadeChange lc = new _860_lemonadeChange();
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        boolean change = lc.lemonadeChange(bills);
        System.out.println(change);
    }
}
