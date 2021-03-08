package leetcode;

public class _441_arrangeCoins {
    public int arrangeCoins(int n) {
        int low = 1;
        int high = n;
        long mid,sum;//使用long类型是为了应对 输入：1804289383 时，计算sum值超出int的取值范围的情况
        while(low<=high)
        {
            mid = low + (high - low )/2;
            sum = mid*(mid+1)/2;
            if(sum == n)
            {
                return (int)mid;//强制类型转换，将long类型转换为int类型
            }
            else if(n > sum)
            {
                low = (int)mid + 1;
            }
            else
            {
                high = (int)mid - 1;
            }
        }
        return high;//return low - 1;是同样的结果。因为最后high<low,而根据题意，k取较小值
    }
}
