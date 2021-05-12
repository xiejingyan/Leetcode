package leetcode;

import java.lang.reflect.Method;
import java.util.Scanner;

public class kuaishou_faceTest {
    public static void main(String[] args) throws Exception {
        Class<?> test = Class.forName("leetcode.test");
        Method m = test.getMethod("method", int.class);
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        m.invoke(test.getDeclaredConstructor().newInstance(), a);
    }
}

class test {
    private Exception Exception;

    public void method(int a) throws Exception {
        System.out.println(a);
        if (a > 10) {
            throw Exception;
        }
    }
}
