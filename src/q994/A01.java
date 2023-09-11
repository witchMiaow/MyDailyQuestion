package q994;

/**
 * @author miaow
 */
public class A01 {

    public static void main(String[] args) {
        int[][] array = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result1 = orangesRotting(array);
        System.out.println("result: 4, actual: " + result1);
        int[][] array2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int result2 = orangesRotting(array2);
        System.out.println("result: -1, actual: " + result2);
        int[][] array3 = {{0, 2}};
        int result3 = orangesRotting(array3);
        System.out.println("result: 0, actual: " + result3);
    }


    public static int orangesRotting(int[][] grid) {
        int result = 0;
        if (!judge(grid)) {
            return result;
        }

        boolean flag;
        do {
            result++;
            boolean change = false;
            for (int i = 0; i < grid.length; i++) {
                int[] column = grid[i];
                for (int j = 0; j < column.length; j++) {
                    int value = column[j];
                    if (value == 2) {
                        grid[i][j] = 4;
                        if (i != 0) {
                            int temp = grid[i - 1][j];
                            if (temp == 1) {
                                grid[i - 1][j] = 3;
                                change = true;
                            }
                        }

                        if (i != grid.length - 1) {
                            int temp = grid[i + 1][j];
                            if (temp == 1) {
                                grid[i + 1][j] = 3;
                                change = true;
                            }
                        }

                        if (j != 0) {
                            int temp = grid[i][j - 1];
                            if (temp == 1) {
                                grid[i][j - 1] = 3;
                                change = true;
                            }
                        }

                        if (j != column.length - 1) {
                            int temp = grid[i][j + 1];
                            if (temp == 1) {
                                grid[i][j + 1] = 3;
                                change = true;
                            }
                        }
                    }
                }
            }
            change(grid);
            flag = change;
        } while (flag);
        if (judge(grid)) {
            return -1;
        } else {
            return result -1;
        }
    }

    private static boolean judge(int[][] grid) {
        for (int[] ary : grid) {
            for (int i : ary) {
                if (i == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void change(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int[] column = grid[i];
            for (int j = 0; j < column.length; j++) {
                int value = column[j];
                if (value == 3) {
                    grid[i][j] = 2;
                }
            }
        }
    }
}
