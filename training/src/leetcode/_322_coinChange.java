package leetcode;

import java.util.Arrays;

public class _322_coinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        Arrays.sort(coins);
        int[] amounts = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && amounts[i - coin] != -1) {
                    min = Math.min(min, amounts[i - coin] + 1);
                }
            }
            amounts[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return amounts[amount];
    }

//    记忆化搜索
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange1(coins, amount, new int[amount]);
    }
    private int coinChange1(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange1(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

//    动态规划
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] cs = {3, 7, 405, 436};
        _322_coinChange cc = new _322_coinChange();
        System.out.println(cc.coinChange(cs, 8839));
    }
}
