package leetcode;

public class _978_maxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1, tmp = 1;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (tmp == 1) {
                if (arr[i] > arr[i + 1]) {
                    tmp++;
                    flag = false;
                }
                else if (arr[i] < arr[i + 1]){
                    tmp++;
                }
            }
            else {
                if (flag) {
                    if (arr[i] > arr[i + 1]) {
                        tmp++;
                        flag = false;
                    }
                    else if (arr[i] == arr[i + 1]) {
                        res = Math.max(res, tmp);
                        tmp = 1;
                    }
                    else {
                        res = Math.max(res, tmp);
                        tmp = 2;
                    }
                }
                else {
                    if (arr[i] < arr[i + 1]) {
                        tmp++;
                        flag = true;
                    }
                    else if (arr[i] == arr[i + 1]) {
                        res = Math.max(res, tmp);
                        tmp = 1;
                        flag = true;
                    }
                    else {
                        res = Math.max(res, tmp);
                        tmp = 2;
                    }
                }
            }
        }
        res = Math.max(res, tmp);
        return res;
    }

//    滑动窗口
    public int maxTurbulenceSize1(int[] arr) {
        int n = arr.length;
        int ret = 1;
        int left = 0, right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }

//    动态规划
    public int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i - 1] > arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] < arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }

        int ret = 1;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i][0]);
            ret = Math.max(ret, dp[i][1]);
        }
        return ret;
    }

    public int maxTurbulenceSize3(int[] arr) {
        int ret = 1;
        int n = arr.length;
        int dp0 = 1, dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ret = Math.max(ret, dp0);
            ret = Math.max(ret, dp1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        _978_maxTurbulenceSize mts = new _978_maxTurbulenceSize();
        System.out.println(mts.maxTurbulenceSize(arr));
    }
}
