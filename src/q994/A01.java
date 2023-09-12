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
        // 定义腐烂了几次
        int result = 0;
        // 先判断是否没有新鲜的橘子
        if (!judge(grid)) {
            return result;
        }

        // 标记 没有发生腐烂时跳出循环
        boolean flag;
        do {
            result++;
            // 标记本次循环是否发生了腐烂, false代表没有新鲜橘子或者新鲜橘子无法到达
            boolean change = false;
            // 遍历所有值
            for (int i = 0; i < grid.length; i++) {
                int[] column = grid[i];
                for (int j = 0; j < column.length; j++) {
                    int value = column[j];
                    //值为2时, 开始腐烂
                    if (value == 2) {
                        // 已经发生过腐烂的位置设置为4, 下次循环时跳过
                        grid[i][j] = 4;
                        // 判断四个方向, 存在1时设置为3, 防止本次循环重复腐烂
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
            // 循环结束后把3再设置为2
            change(grid);
            flag = change;
        } while (flag);
        if (judge(grid)) {
            return -1;
        } else {
            return result - 1;
        }
    }

    /**
     * 判断数组内是否还有新鲜的橘子
     *
     * @param grid 数组
     * @return true 有新鲜的橘子
     */
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

    /**
     * 改变数组内的3为2
     *
     * @param grid 数组
     */
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
