package leetcode;

public class _995_minKBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int res = 0, i = 0, start = 0, num = 0;
        for (; i < A.length; i++) {
            if (A[i] == 0) {
                if (num == 0) {
                    start = i;
                }
                num++;
                A[i] = 1;
                if (num == K) {
                    res++;
                    num = 0;
                }
            }
            else {
                if (num > 0) {
                    if (start + K + num > A.length) {
                        return -1;
                    }
                    for (int j = 0; j < num; j++) {
                        if (A[start + K + j] == 0) {
                            A[start + K + j] = 1;
                        }
                        else {
                            A[start + K + j] = 0;
                        }
                    }
                    res += 2;
                    num = 0;
                }
            }
        }
        if (num > 0) {
            return -1;
        }
        return res;
    }

//    差分数组
    public int minKBitFlips1(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

//    异或差分数组
    public int minKBitFlips2(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt ^= diff[i];
            if (A[i] == revCnt) { // A[i] ^ revCnt == 0
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                diff[i + K] ^= 1;
            }
        }
        return ans;
    }

//    滑动窗口
    public int minKBitFlips3(int[] A, int K) {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }
}
