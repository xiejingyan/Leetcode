package leetcode;

import java.util.HashMap;

public class _36_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] flag = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (flag[board[i][j] - '1'] == 0) {
                        flag[board[i][j] - '1'] = 1;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            int[] flag = new int[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (flag[board[i][j] - '1'] == 0) {
                        flag[board[i][j] - '1'] = 1;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] flag = new int[9];
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] != '.') {
                            if (flag[board[m][n] - '1'] == 0) {
                                flag[board[m][n] - '1'] = 1;
                            }
                            else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

//    一次迭代
    public boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}
