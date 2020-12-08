package leetcode;

public class _845_longestMountain {
    public int longestMountain(int[] A) {
        if (A.length <= 2) return 0;
        int result = 0, tmp = 0;
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                if (A[i] < A[i - 1] && flag) {
                    result = Math.max(result, ++tmp);
                }
                else if (A[i] >= A[i - 1] && flag) result = Math.max(result, tmp);
            }
            else if (A[i + 1] > A[i]) {
                if (tmp == 0) tmp++;
                else if (A[i - 1] >= A[i]) {
                    result = Math.max(result, ++tmp);
                    flag = false;
                    tmp = 1;
                }
                else tmp++;
            }
            else if (A[i + 1] < A[i] && tmp != 0) {
                flag = true;
                tmp++;
            }
            else if (A[i] == A[i + 1] && tmp != 0){
                result = Math.max(result, ++tmp);
                flag = false;
                tmp = 0;
            }
        }
        return result > 2 ? result : 0;
    }

    public int longestMountain1(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    public int longestMountain2(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }
}
