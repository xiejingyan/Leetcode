package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _118_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        else {
            List<Integer> num = new ArrayList<>();
            num.add(1);
            res.add(num);
            for (int i = 1; i < numRows; i++) {
                List<Integer> nr = new ArrayList<>();
                nr.add(res.get(i - 1).get(0));
                for (int j = 1; j < res.get(i - 1).size(); j++) {
                    nr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
                nr.add(res.get(i - 1).get(res.get(i - 1).size() - 1));
                res.add(nr);
            }
        }
        return res;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
