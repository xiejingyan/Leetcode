package makeDataset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MakeData {
    public static List<String> readMethod(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        List<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(name));
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                if (str.charAt(0) == 'C' && str.charAt(1) == '0' && str.charAt(2) == '1') {
                    str = str.replace('C', '1');
                    arrayList.add(str);
                }
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void writeMethod(List<String> strings, String name) {
        int flag = 0;
        for (int tmp = 0; tmp < 10; tmp++) {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(name + "-" + tmp + ".csv"));
                out.write("L,SVN,PR,DO,CP,SNR");
                out.newLine();
                for (; flag - tmp * 100 < 100; flag++) {
                    int n = (strings.get(flag).length() - 1) / 16;
                    List<String> res = new ArrayList<>();
                    res.add(strings.get(flag).substring(0, 3));
                    int j = 4;
                    int num = n / 4;
                    if (n % 4 != 0) {
                        num++;
                    }
                    while (strings.get(flag).startsWith("             ", j)) {
                        j += 16;
                    }
                    for (int i = 0;i < 4; i++) {
                        if (j >= strings.get(flag).length()) {
                            res.add("             ");
                        }
                        else {
                            res.add(strings.get(flag).substring(j, j + 13));
                            j += 16 * num;
                        }
                    }
                    if (res.contains("             ")) {
                        continue;
                    }
                    out.write("1," + res.get(0) + "," + res.get(1) + "," + res.get(2) + "," + res.get(3) + "," + res.get(4));
                    out.newLine();
                }
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = readMethod("/Users/xpp/Desktop/data/jfng1200.20o");
        writeMethod(strings, "/Users/xpp/Desktop/data-jfng1200-C01");
    }
}
