package makeDataset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MakeData_2 {
    public static List<String> readMethod(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        List<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(name));
            String str;
            // 按行读取字符串
            boolean flag = false;
            int n = 0;
            while ((str = bf.readLine()) != null) {
                if (!str.equals("") && str.charAt(32) == 'G') {
                    n = 0;
                    for (int i = 33; i < str.length();) {
                        if (str.charAt(i) == '1' && str.charAt(i + 1) == '0') {
                            flag = true;
                            break;
                        }
                        else {
                           i += 3;
                           n += 2;
                        }
                    }
                    continue;
                }
                if (flag) {
                    if (n == 0) {
                        arrayList.add(str);
                        flag = false;
                    }
                    else {
                        n--;
                    }
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
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(name + "-G10.csv"));
            out.write("L,SVN,PR,DO,CP,SNR");
            out.newLine();
            int n = 1;
            for (; flag < strings.size(); flag++) {
                List<String> res = new ArrayList<>();
                res.add(strings.get(flag).substring(0, 13));
                res.add(strings.get(flag).substring(32, 45));
                res.add(strings.get(flag).substring(16, 29));
                res.add(strings.get(flag).substring(48, 61));
                out.write(n + ",110," + res.get(0) + "," + res.get(1) + "," + res.get(2) + "," + res.get(3));
                n++;
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> strings = readMethod("/Users/xpp/Desktop/DATA/tongzhou/Z_UPAR_I_540001_20201126050000_O_GPS2.rnx/home331f00.20o");
        writeMethod(strings, "/Users/xpp/Desktop/home331f00.20o");
    }
}
