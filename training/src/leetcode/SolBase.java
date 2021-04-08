package leetcode;

import java.util.Random;

public class SolBase {
    public int rand7() {
        Random r = new Random();
        return r.nextInt(7) + 1;
    }
}
