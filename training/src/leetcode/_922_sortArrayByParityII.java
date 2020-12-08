package leetcode;

public class _922_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, tmp;
        for (; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                for (;j < A.length; j += 2) {
                    if (A[j] % 2 == 0) {
                        tmp = A[i];
                        A[i] = A[j];
                        A[j] = tmp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    public int[] sortArrayByParityII1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        int i = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : A) {
            if (x % 2 == 1) {
                ans[i] = x;
                i += 2;
            }
        }
        return ans;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
