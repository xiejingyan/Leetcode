package leetcode;

import java.util.Scanner;

public class ali_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] location = new int[2];
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        char[][] city = new char[n][m];
        for (int i = 0; i < n; i++) {
            String nextLine = "";
            while (nextLine.equals("")) {
                nextLine = sc.nextLine();
            }
            char[] chars = nextLine.toCharArray();
            for (int j = 0; j < m; j++) {
                city[i][j] = chars[j];
                if (city[i][j] == '@') {
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        for (int tmp = 0; tmp < k; tmp++) {
            String s = sc.nextLine();
            int i;
            switch (s) {
                case "NORTH":
                    i = location[0];
                    while (i > 0 && city[i - 1][location[1]] != '#') {
                        i--;
                    }
                    location[0] = i;
                    break;
                case "SOUTH":
                    i = location[0];
                    while (i < n - 1 && city[i + 1][location[1]] != '#') {
                        i++;
                    }
                    location[0] = i;
                    break;
                case "WEST":
                    i = location[1];
                    while (i > 0 && city[location[0]][i - 1] != '#') {
                        i--;
                    }
                    location[1] = i;
                    break;
                default:
                    i = location[1];
                    while (i < m - 1 && city[location[0]][i + 1] != '#') {
                        i++;
                    }
                    location[1] = i;
                    break;
            }
        }
        System.out.println(location[0] + " " + location[1]);
    }
}
