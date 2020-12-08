package leetcode;

public class _122_maxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length <= 0) return res;
        int buy = -1;
        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) {
                if (buy != -1) res += prices[i] - buy;
            }
            else if (prices[i + 1] > prices[i] && buy == -1) buy = prices[i];
            else if (prices[i + 1] < prices[i] && buy != -1) {
                res += prices[i] - buy;
                buy = -1;
            }
        }
        return res;
    }

//    动态规划
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

//    贪心算法
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }


}
