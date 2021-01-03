package leetcode;

public class _605_canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 1;
        for (int i : flowerbed) {
            if (i == 0) {
                num++;
                if (num == 3) {
                    n--;
                    num = 1;
                }
                if (n == 0) {
                    break;
                }
            }
            else {
                num = 0;
            }
        }
        if (n != 0 && num == 2) {
            n--;
        }
        return n == 0;
    }

//    贪心
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
}
