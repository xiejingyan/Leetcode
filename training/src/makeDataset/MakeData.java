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
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(name));
            out.write("L,SVN,PR,DO,CP,SNR");
            out.newLine();
            for (String s : strings) {
                int n = (s.length() - 1) / 16;
                List<String> res = new ArrayList<>();
                res.add(s.substring(0, 3));
                int j = 4;
                int num = n / 4;
                if (n % 4 != 0) {
                    num++;
                }
                while (s.startsWith("             ", j)) {
                    j += 16;
                }
                for (int i = 0;i < 4; i++) {
                    if (j >= s.length()) {
                        res.add("             ");
                    }
                    else {
                        res.add(s.substring(j, j + 13));
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

    public static void main(String[] args) {
        List<String> strings = readMethod("/Users/xpp/Desktop/urum1500.20o");
        writeMethod(strings, "/Users/xpp/Desktop/data-urum-G01.csv");
    }
}
