package leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class _239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int n = 1, tmp = -1;
        res[0] = Integer.MIN_VALUE;
        for (int j = 0; j < k; j++) {
            if (nums[j] > res[0]) {
                res[0] = nums[j];
                tmp = j;
            }
        }
        for (int i = 1; i <= nums.length - k; i++) {
            if (tmp < i) {
                int m = Integer.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    if (nums[i + j] >= m) {
                        m = nums[i + j];
                        tmp = i + j;
                    }
                }
                res[n] = m;
            }
            else {
                if (nums[i + k - 1] >= nums[tmp]) {
                    res[n] = nums[i + k - 1];
                    tmp = i + k - 1;
                }
                else {
                    res[n] = nums[tmp];
                }
            }
            n++;
        }
        return res;
    }

//    优先队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

//    单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
