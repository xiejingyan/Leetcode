package leetcode;

public class _189_rotate {
    public void rotate(int[] nums, int k) {
        if (k != 0 && k != nums.length) {
            int n = 1;
            for (int i = 2; i < 11; i++) {
                if (nums.length % i == 0 && k % i == 0) {
                    n = i;
                }
            }
            for (int j = 0; j < n; j++) {
                int num = nums[j];
                for (int i = k + j; ; i += k) {
                    while (i > nums.length - 1) {
                        i -= nums.length;
                    }
                    int tmp = nums[i];
                    nums[i] = num;
                    num = tmp;
                    if (i == j) {
                        break;
                    }
                }
            }
        }
    }

//    使用额外数组
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

//    环状替换
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

//    数组翻转
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        _189_rotate r = new _189_rotate();
        int[] nums = {-1, -100, 3, 99};
        r.rotate(nums, 2);
    }
}
