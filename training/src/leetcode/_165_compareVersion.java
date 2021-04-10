package leetcode;

public class _165_compareVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int a, b;
            if (i >= v1.length) {
                a = 0;
                b = Integer.parseInt(v2[i]);
            }
            else if (i >= v2.length) {
                b = 0;
                a = Integer.parseInt(v1[i]);
            }
            else {
                a = Integer.parseInt(v1[i]);
                b = Integer.parseInt(v2[i]);
            }
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
        }
        return 0;
    }

//    分割遍历
    public int compareVersion1(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

//    双指针遍历
//    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
//        // if pointer is set to the end of string
//        // return 0
//        if (p > n - 1) {
//            return new Pair(0, p);
//        }
//        // find the end of chunk
//        int i, pEnd = p;
//        while (pEnd < n && version.charAt(pEnd) != '.') {
//            ++pEnd;
//        }
//        // retrieve the chunk
//        if (pEnd != n - 1) {
//            i = Integer.parseInt(version.substring(p, pEnd));
//        } else {
//            i = Integer.parseInt(version.substring(p, n));
//        }
//        // find the beginning of next chunk
//        p = pEnd + 1;
//
//        return new Pair(i, p);
//    }
//    public int compareVersion2(String version1, String version2) {
//        int p1 = 0, p2 = 0;
//        int n1 = version1.length(), n2 = version2.length();
//
//        // compare versions
//        int i1, i2;
//        Pair<Integer, Integer> pair;
//        while (p1 < n1 || p2 < n2) {
//            pair = getNextChunk(version1, n1, p1);
//            i1 = pair.getKey();
//            p1 = pair.getValue();
//
//            pair = getNextChunk(version2, n2, p2);
//            i2 = pair.getKey();
//            p2 = pair.getValue();
//            if (i1 != i2) {
//                return i1 > i2 ? 1 : -1;
//            }
//        }
//        // the versions are equal
//        return 0;
//    }
}
