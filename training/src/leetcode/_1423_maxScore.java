package leetcode;

import java.util.Arrays;

public class _1423_maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int all = 0, min = 0, i = 0, tmp = 0;
        for (int cardPoint : cardPoints) {
            all += cardPoint;
        }
        for (; i < cardPoints.length - k; i++) {
            min += cardPoints[i];
        }
        tmp = min;
        for (; i < cardPoints.length; i++) {
            tmp -= cardPoints[i + k - cardPoints.length];
            tmp += cardPoints[i];
            min = Math.min(min, tmp);
        }
        return all - min;
    }

//    滑动窗口
    public int maxScore1(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
