package leetcode;

public class _1004_longestOnes {
    public int longestOnes(int[] A, int K) {
        int res = 0, start = 0, num = 0, flag = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (flag == -1) {
                    flag = i;
                }
                if (num < K) {
                    num++;
                }
                else {
                    res = Math.max(res, i - start);
                    flag++;
                    start = flag;
                    for (; flag < A.length; flag++) {
                        if (A[flag] == 0) {
                            break;
                        }
                    }
                }
            }
        }
        return Math.max(res, A.length - start);
    }

//    二分查找
    public int longestOnes1(int[] A, int K) {
        int n = A.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + (1 - A[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - K);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
    public int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

//    滑动窗口
    public int longestOnes2(int[] A, int K) {
        int n = A.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - A[right];
            while (lsum < rsum - K) {
                lsum += 1 - A[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        _1004_longestOnes lo = new _1004_longestOnes();
        System.out.println(lo.longestOnes(A, 2));
    }
}
